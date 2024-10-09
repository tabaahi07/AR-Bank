package org.example.core;

import org.example.IBankApp;
import org.example.commons.*;
import org.example.core.services.AuthService;

import lombok.Builder;

@Builder
public class BankApp implements IBankApp {

    private AuthService authService;

    @Override
    public CustomerLoginResponse customerLogin(CustomerLoginRequest request) {
        return CustomerLoginResponse.builder()
                .accessToken(authService.login(request.getUserId(), request.getPasswd()))
                .build();
    }

    @Override
    public AddCustomerDetailsResponse createCustomer(AddCustomerDetailsRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCustomer'");
    }

    @Override
    public AddCustomerAccountResponse createCustomerAccount(AddCustomerAccountRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCustomerAccount'");
    }

    @Override
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
