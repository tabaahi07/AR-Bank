package org.example.commons;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

@Builder
public class ListCustomerAccountResponse {
    List<CustomerAccount> customerAccounts;

    @Builder
    public static class CustomerAccount {
        String accountId;
        String accountNumber;
        LocalDate createdDate;
    }
}
