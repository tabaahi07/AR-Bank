package org.example.commons;

import lombok.Getter;

@Getter
public class DepositAmountRequest extends AuthenticatedRequest {
    private String accountNumber ;
    private Integer amount;
}
