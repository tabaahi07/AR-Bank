package main.java.org.example;

import main.java.org.example.commons.AddCustomerDetailsRequest;
import main.java.org.example.commons.AddCustomerDetailsResponse;
import main.java.org.example.commons.CustomerLoginRequest;
import main.java.org.example.commons.CustomerLoginResponse;

public interface IBankApp {
    /**
     * logs in Customer and returns access token
     * @param userId
     * @param passwd
     * @return access token
     */
    public CustomerLoginResponse customerLogin(CustomerLoginRequest request);

    /**
     * create Customer Account
     * @param request
     * @return
     */
    public AddCustomerDetailsResponse createCustomer(AddCustomerDetailsRequest request);

    /**
     * create Customer Account
     * @param request
     * @return
     */
    public AddCustomerDetailsResponse createCustomerAccount(AddCustomerDetailsRequest request);
}
