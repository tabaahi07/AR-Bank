package org.example.commons;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class WithdrawAmountRequest extends AuthenticatedRequest {
    private String accountId;
    private Integer amount;
}
