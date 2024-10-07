package org.example.commons;
import org.example.commons.Enums.BalanceCheckStatus;

import lombok.Builder;

@Builder
public class AccountBalanceResponse {
    private Integer balance;
    private BalanceCheckStatus balanceCheckStatus ;
}
