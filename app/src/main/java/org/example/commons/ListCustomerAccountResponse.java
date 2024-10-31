package org.example.commons;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder

public class ListCustomerAccountResponse {
    List<CustomerAccount> customerAccounts;

    class CustomerAccount {
        String accountNumber;
        LocalDateTime createdDate;
    }
}
