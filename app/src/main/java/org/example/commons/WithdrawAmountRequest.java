package org.example.commons;

import lombok.Getter;

@Getter
public class WithdrawAmountRequest extends AuthenticatedRequest {
    private String accountNumber ;
    private Integer amount;
}
