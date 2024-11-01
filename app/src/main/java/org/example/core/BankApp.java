package org.example.core;

import org.example.IBankApp;
import org.example.commons.*;
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
        return AddCustomerDetailsResponse.builder().customerId(customerService.addCustomer(request)).build() ;
    }

    @Override
    public AddCustomerAccountResponse createCustomerAccount(AddCustomerAccountRequest request) {
       return AddCustomerAccountResponse.builder().accountNumber(accountService.createAccount(request.getCustomerId())).build() ;
    }

    @Override
    public ListCustomerAccountResponse listCustomerAccounts(ListCustomerAccountRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listCustomerAccounts'");
    }

   public SetAccountBalanceResponse setAccountBalanceResponse(SetAccountBalanceRequest request){
    
     TransactionReceipt receipt = accountService.setAccountBalance(request.getAccountNumber() , request.getAmount() , request.getTransactionType()) ;

     return SetAccountBalanceResponse.builder().transactionAmount(request.getAmount()).status(receipt.getStatus()).transactionDateAndTime(receipt.getTransactionDateAndTime()).transactionId(receipt.getTransactionId()).build() ;
   }


    @Override
    public AccountBalanceResponse accountBalance(AccountBalanceRequest request) {
        return AccountBalanceResponse.builder().balance(accountService.getBalance(request.getAccountNumber())).build() ;
    }

}
