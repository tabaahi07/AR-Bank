package org.example;

import org.example.commons.*;

public interface IBankApp {
    /**
     * logs in Customer and returns access token
     * @param userId
     * @param passwd
     * @return access token
     */
    public CustomerLoginResponse customerLogin(CustomerLoginRequest request);

    /**
     * create Customer
     * @param request
     * @return
     */
    public AddCustomerDetailsResponse createCustomer(AddCustomerDetailsRequest request);

    /**
     * create Customer Account
     * @param request
     * @return
     */
    public AddCustomerAccountResponse createCustomerAccount(AddCustomerAccountRequest request);

    /**
     * list Customer Accounts
     * @param request
     * @return
     */
    public ListCustomerAccountResponse listCustomerAccounts(ListCustomerAccountRequest request);

    /**
     * Deposit or withdraw Amount into account
     * @param request
     * @return
     */
    public SetAccountBalanceResponse setAccountBalanceResponse(SetAccountBalanceRequest request);


    /**
     * Get Balance of a particular account
     * @param request
     * @return
     */
    public AccountBalanceResponse accountBalance(AccountBalanceRequest request);
}
