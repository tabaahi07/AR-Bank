package org.example.commons;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AccountBalanceRequest extends AuthenticatedRequest {
    private String accountId;
}
