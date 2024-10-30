package org.example.commons;

import java.time.* ;
import org.example.commons.Enums.WithdrawStatus;

import lombok.Builder;

@Builder
public class WithdrawAmountResponse {
    private WithdrawStatus status;
    private Integer accountBalance;
    private String transactionId;
    private LocalDateTime transactionDateAndTime ;
    private Integer transactionAmount;
}
