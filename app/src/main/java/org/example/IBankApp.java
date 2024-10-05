package main.java.org.example;

import main.java.org.example.commons.AccountBalanceRequest;
import main.java.org.example.commons.AccountBalanceResponse;
import main.java.org.example.commons.AddCustomerAccountRequest;
import main.java.org.example.commons.AddCustomerAccountResponse;
import main.java.org.example.commons.AddCustomerDetailsRequest;
import main.java.org.example.commons.AddCustomerDetailsResponse;
import main.java.org.example.commons.CustomerLoginRequest;
import main.java.org.example.commons.CustomerLoginResponse;
import main.java.org.example.commons.DepositAmountRequest;
import main.java.org.example.commons.DepositAmountResponse;
import main.java.org.example.commons.ListCustomerAccountRequest;
import main.java.org.example.commons.ListCustomerAccountResponse;
import main.java.org.example.commons.WithdrawAmountRequest;
import main.java.org.example.commons.WithdrawAmountResponse;

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
     * Deposit Amount into account
     * @param request
     * @return
     */
    public DepositAmountResponse depositAmount(DepositAmountRequest request);

    /**
     * Withdraw Amount from account
     * @param request
     * @return
     */
    public WithdrawAmountResponse withdrawAmount(WithdrawAmountRequest request);

    /**
     * Get Balance of a particular account
     * @param request
     * @return
     */
    public AccountBalanceResponse accountBalance(AccountBalanceRequest request);
}
