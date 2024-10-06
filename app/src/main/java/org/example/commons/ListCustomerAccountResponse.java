package org.example.commons;

import java.time.LocalDateTime;
import java.util.List;

public class ListCustomerAccountResponse {
    List<CustomerAccount> customerAccounts;

    class CustomerAccount {
        String accountId;
        String accountNumber;
        LocalDateTime createdDate;
    }
    
}
