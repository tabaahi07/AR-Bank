package org.example.core;
import org.example.IBankApp;
import org.example.commons.*;
import org.example.core.data.Accounts;
import org.example.core.dto.TransactionReceipt;
import org.example.core.services.AccountsService;
import org.example.core.services.AuthService;
import org.example.core.services.CustomerService;
import java.util.* ;
import lombok.Builder;

@Builder
public class BankApp implements IBankApp {

    private AuthService authService ;
    private CustomerService customerService ;
    private AccountsService accountService ;

    @Override
    public CustomerLoginResponse customerLogin(CustomerLoginRequest request) {
        return CustomerLoginResponse.builder()
                .accessToken(authService.login(request.getUserId(), request.getPasswd()))
                .build();
    }
    
    @Override
    public AddCustomerDetailsResponse createCustomer(AddCustomerDetailsRequest request) {
        return AddCustomerDetailsResponse.builder()
            .customerId(customerService.addCustomer(request))
            .build() ;
    }

    @Override
    public AddCustomerAccountResponse createCustomerAccount(AddCustomerAccountRequest request) {
       return AddCustomerAccountResponse.builder().
            accountNumber(accountService.createAccount(request.getCustomerId() , request.getAccessToken())).build() ;
    }

    @Override
    public ListCustomerAccountResponse listCustomerAccounts(ListCustomerAccountRequest request) {
        Optional<List<Accounts>> accountList = accountService.listAccounts(request.getCustomerId() , request.getAccessToken()) ;
        return ListCustomerAccountResponse.builder().
            customerAccounts(accountList)
            .build() ;
    }

   public SetAccountBalanceResponse setAccountBalanceResponse(SetAccountBalanceRequest request){

     Optional<TransactionReceipt> receipt = accountService.setAccountBalance(request.getCustomerId() , request.getAccessToken() , request.getAccountNumber() , request.getAmount() , request.getTransactionType()) ;

     if(receipt == null) return null ;
     return SetAccountBalanceResponse.builder()
            .transactionAmount(request.getAmount())
            .status(receipt.get().getStatus())
            .transactionDateAndTime(receipt.get().getTransactionDateAndTime()).transactionId(receipt.get().getTransactionId()).
            build() ;
   }

    @Override
    public AccountBalanceResponse accountBalance(AccountBalanceRequest request) {
        return AccountBalanceResponse.builder().balance(accountService.getBalance(request.getCustomerId() , request.getAccessToken()  , request.getAccountNumber())).build() ;
    }

}
