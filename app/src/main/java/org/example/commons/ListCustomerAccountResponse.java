package org.example.commons;
import lombok.*;
import java.util.List;
import java.util.Optional;

import org.example.core.data.Accounts;

@Builder

public class ListCustomerAccountResponse {
    Optional<List<Accounts>> customerAccounts;
}
