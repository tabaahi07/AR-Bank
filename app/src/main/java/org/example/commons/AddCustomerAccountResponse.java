package org.example.commons;
import lombok.Builder; 

@Builder
public class AddCustomerAccountResponse {
    private String accountId;
    private String accountNumber;
    private String customerId;    
    private Enum AccountCreationStatus ;
}
