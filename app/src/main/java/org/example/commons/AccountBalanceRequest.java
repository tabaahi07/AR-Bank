package org.example.commons;

import lombok.Getter;

@Getter
public class AccountBalanceRequest extends AuthenticatedRequest {
    private String accountNumber ;
}
