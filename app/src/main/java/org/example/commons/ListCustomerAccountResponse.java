package org.example.commons;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

import org.example.commons.Enums.ListCustomerAccountResponseStatus;

@Builder
public class ListCustomerAccountResponse {
    List<CustomerAccount> customerAccounts;
    ListCustomerAccountResponseStatus listCustomerAccountResponseStatus ;

    @Builder
    public static class CustomerAccount {
        String accountId;
        String accountNumber;
        LocalDate createdDate;
    }
}
