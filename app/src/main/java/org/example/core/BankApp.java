package org.example.core ;
import org.example.IBankApp ;
import org.example.commons.* ;
import java.util.* ;
import java.time.* ;
import org.example.commons.Data.AccountData;
import org.example.commons.Data.CustomerData;
import org.example.commons.Data.DataStore;
import org.example.commons.Data.LoginSession;
import org.example.commons.Enums.AccountCreationStatus;
import org.example.commons.Enums.BalanceCheckStatus;
import org.example.commons.Enums.DepositStatus;
import org.example.commons.Enums.ListCustomerAccountResponseStatus;
import org.example.commons.Enums.WithdrawStatus;



public class BankApp implements IBankApp {
	public Boolean isValidSession(String currentSessionLoginToken ){
		LocalDateTime currentDateTime = LocalDateTime.now() ;
		for(String key : DataStore.getInstance().LoginSessionMap.keySet()){
			List<LoginSession> loginSessionList = DataStore.getInstance().LoginSessionMap.get(key) ;
			for(LoginSession it : loginSessionList){
				Duration duration = Duration.between(it.getLoginDateAndTime() , currentDateTime) ;
				if (currentSessionLoginToken == it.getLoginToken() && Math.abs(duration.toMinutes()) <= 15){
					return true ;
				} 
			}
		}
		return false ;
	}

	public CustomerLoginResponse customerLogin(CustomerLoginRequest request){
		String randomID = UUID.randomUUID().toString() ;
		String token = request.getCustomerId() + "_"  + randomID ;
		LoginSession LoginSessionObj = LoginSession.builder().customerId(request.getCustomerId()).loginToken(token).loginDateAndTime(LocalDateTime.now()).build() ;
		List<LoginSession> LoginSessionList = DataStore.getInstance().LoginSessionMap.get(request.getCustomerId()) ;
		LoginSessionList.add(LoginSessionObj) ;
		return CustomerLoginResponse.builder().accessToken(token).build() ;
	}
	
	public AddCustomerDetailsResponse createCustomer(AddCustomerDetailsRequest request) {
		String randomID = UUID.randomUUID().toString() ;
		String defaultPassword = "12345678" ;
		CustomerData customerDataObj = CustomerData.builder().customerId(randomID)
		.passwordHash(defaultPassword)
		.firstName(request.getFirstName())
		.lastName(request.getLastName())
		.middleName(request.getMiddleName())
		.PAN(request.getPAN())
		.aadharNumber(request.getAadharNumber())
		.address(request.getAddress())
		.dateOfBirth(request.getDateOfBirth())
		.email(request.getEmail())
		.build() ;
      
		DataStore.getInstance().CustomerDataMap.put(randomID , customerDataObj) ; 
		return AddCustomerDetailsResponse.builder().customerId(randomID).defaultPassword(defaultPassword).build() ;
	}

	public AddCustomerAccountResponse createCustomerAccount(AddCustomerAccountRequest request) {

		String accountId = UUID.randomUUID().toString() ;
		String accountNumber = UUID.randomUUID().toString() ;
		// checking if loginToken match if existing login Session within specified time range
		if(isValidSession(request.getLoginToken())){
			AccountData accountDataObj = AccountData.builder().accountId(accountId)
			.accountNumber(accountNumber)
			.currentbalance(0)
			.createdDate(LocalDate.now())
			.customerId(request.getCustomerId()).build() ;

			DataStore.getInstance().AccountDataMap.put(accountId , accountDataObj) ;
			List<AccountData> accountsList = DataStore.getInstance().CustomerAccountsMap.get(request.getCustomerId()) ;

			accountsList.add(accountDataObj) ;
			return AddCustomerAccountResponse.builder().accountId(accountId).accountNumber(accountNumber).customerId(request.getCustomerId()).accountCreationStatus(AccountCreationStatus.APPROVED).build() ;
		}
		else{
			return AddCustomerAccountResponse.builder().accountId("").accountNumber("").accountCreationStatus(AccountCreationStatus.REJECTED).build() ;
		}
	}

	public ListCustomerAccountResponse listCustomerAccounts(ListCustomerAccountRequest request) {
		if(isValidSession(request.getLoginToken())){
			List<AccountData> customerAccountsList = DataStore.getInstance().CustomerAccountsMap.get(request.getCustomerId()) ;

			return ListCustomerAccountResponse.builder().customerAccounts(
				customerAccountsList.stream().map(
					accountData -> ListCustomerAccountResponse.CustomerAccount.builder().accountId(accountData.getAccountId())
					.accountNumber(accountData.getAccountNumber())
					.createdDate(accountData.getCreatedDate()).build() 
				).toList()
				
			).listCustomerAccountResponseStatus(ListCustomerAccountResponseStatus.APPROVED).build() ; 
		}

		else{
			return ListCustomerAccountResponse.builder().listCustomerAccountResponseStatus(ListCustomerAccountResponseStatus.REJECTED).build() ;
		}

	} 


	public DepositAmountResponse depositAmount(DepositAmountRequest request) {
		if(isValidSession(request.getLoginToken()) && (request.getAmount() > 0)){
			AccountData accountDataObj = DataStore.getInstance().AccountDataMap.get(request.getAccountId()) ;
			accountDataObj.setCurrentbalance(accountDataObj.getCurrentbalance() + request.getAmount()) ;
			String transactionId = UUID.randomUUID().toString() ;
			return DepositAmountResponse.builder().depositStatus(DepositStatus.APPROVED)
			.message("Money deposited")
			.accountBalance(accountDataObj.getCurrentbalance())
			.transactionId(transactionId)
			.transactionDate(LocalDate.now())
			.transactionTime(LocalTime.now())
			.transactionAmount(request.getAmount()).build() ;
		}
		else{
			return DepositAmountResponse.builder().depositStatus(DepositStatus.REJECTED).build() ;
		}
	}


	public WithdrawAmountResponse withdrawAmount(WithdrawAmountRequest request) {
		if(isValidSession(request.getLoginToken()) && request.getAmount() > 0){
			AccountData accountDataObj = DataStore.getInstance().AccountDataMap.get(request.getAccountId()) ;
			accountDataObj.setCurrentbalance(accountDataObj.getCurrentbalance() - request.getAmount()) ;
			String transactionId = UUID.randomUUID().toString() ;
			return WithdrawAmountResponse.builder().withdrawStatus(WithdrawStatus.APPROVED)
			.message("Money withdrawn")
			.accountBalance(accountDataObj.getCurrentbalance())
			.transactionId(transactionId)
			.transactionDate(LocalDate.now())
			.transactionTime(LocalTime.now())
			.transactionAmount(request.getAmount()).build() ;
		}
		else{
			return WithdrawAmountResponse.builder().withdrawStatus(WithdrawStatus.REJECTED).build() ;
		}
	}

	public AccountBalanceResponse accountBalance(AccountBalanceRequest request) {
		if(isValidSession(request.getLoginToken())){
			AccountData userAccountObj = DataStore.getInstance().AccountDataMap.get(request.getAccountId()) ;
			return AccountBalanceResponse.builder().balance(userAccountObj.getCurrentbalance()).balanceCheckStatus(BalanceCheckStatus.APPROVED).build() ;
		}
		else{
			return AccountBalanceResponse.builder().balanceCheckStatus(BalanceCheckStatus.REJECTED).build() ;
		}
	}
}