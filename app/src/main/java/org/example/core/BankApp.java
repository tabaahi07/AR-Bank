package org.example.core;

import org.example.IBankApp;
import org.example.commons.*;
import java.time.* ;
import org.example.commons.Enums.DepositStatus;
import org.example.commons.Enums.WithdrawStatus;
import org.example.core.data.Accounts;
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
       return AddCustomerAccountResponse.builder().customerId(request.getCustomerId()).accountNumber(accountService.createAccount(request.getCustomerId())).build() ;
    }

    @Override
    public ListCustomerAccountResponse listCustomerAccounts(ListCustomerAccountRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listCustomerAccounts'");
    }

    @Override
    public DepositAmountResponse depositAmount(DepositAmountRequest request) {
        String transactionId = UUID.randomUUID().toString();

        Optional<Accounts> accountDetail = accountService.depositAmount(request.getAccountNumber(), request.getAmount()) ;
        
        if(accountDetail.isEmpty()) return DepositAmountResponse.builder().status(DepositStatus.REJECTED).build() ;

        return DepositAmountResponse.builder().status(DepositStatus.APPROVED).accountBalance(accountDetail.get().getBalance()).transactionAmount(request.getAmount()).transactionDateAndTime(LocalDateTime.now()).transactionId(transactionId).build() ;
    }

    @Override
    public WithdrawAmountResponse withdrawAmount(WithdrawAmountRequest request) {
        String transactionId = UUID.randomUUID().toString();

        Optional<Accounts> accountDetail = accountService.withdrawAmount(request.getAccountNumber(), request.getAmount()) ;
        
        if(accountDetail.isEmpty()) return WithdrawAmountResponse.builder().status(WithdrawStatus.REJECTED).build() ;

        return WithdrawAmountResponse.builder().status(WithdrawStatus.APPROVED).accountBalance(accountDetail.get().getBalance()).transactionAmount(request.getAmount()).transactionDateAndTime(LocalDateTime.now()).transactionId(transactionId).build() ;
    }

    @Override
    public AccountBalanceResponse accountBalance(AccountBalanceRequest request) {
        return AccountBalanceResponse.builder().balance(accountService.getBalance(request.getAccountNumber())).build() ;
    }

}
