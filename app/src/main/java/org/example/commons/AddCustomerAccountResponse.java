package org.example.commons;
import org.example.commons.Enums.AccountCreationStatus;

import lombok.Builder; 

@Builder
public class AddCustomerAccountResponse {
    private String accountId;
    private String accountNumber;
    private String customerId;    
    private AccountCreationStatus accountCreationStatus ;
}
