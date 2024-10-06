package org.example.core ;
import org.example.IBankApp ;
import org.example.commons.* ;
import java.util.UUID ;

public class BankApp implements IBankApp {
	public CustomerLoginResponse customerLogin(CustomerLoginRequest request){
		String randomID = UUID.randomUUID().toString() ;
		String token = request.getUserId() + "_"  + randomID ;
		return CustomerLoginResponse.builder().accessToken(token).build() ;
	}
	
	public AddCustomerDetailsResponse createCustomer(AddCustomerDetailsRequest request) {
		String randomID = UUID.randomUUID().toString() ;
		String defaultPassword = "12345678" ;
		return AddCustomerDetailsResponse.builder().customerId(randomID).defaultPassword(defaultPassword).build() ;
	}

	public AddCustomerAccountResponse createCustomerAccount(AddCustomerAccountRequest request) {
		String accountId = UUID.randomUUID().toString() ;
		String accountNumber = UUID.randomUUID().toString() ;
		return AddCustomerAccountResponse.builder().accountId(accountId).accountNumber(accountNumber).customerId(request.getCustomerId()).build() ;
	}

	public ListCustomerAccountResponse listCustomerAccounts(ListCustomerAccountRequest request) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listCustomerAccounts'");
	}

	@Override
	public DepositAmountResponse depositAmount(DepositAmountRequest request) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'depositAmount'");
	}

	@Override
	public WithdrawAmountResponse withdrawAmount(WithdrawAmountRequest request) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'withdrawAmount'");
	}

	@Override
	public AccountBalanceResponse accountBalance(AccountBalanceRequest request) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'accountBalance'");
	}
	
}