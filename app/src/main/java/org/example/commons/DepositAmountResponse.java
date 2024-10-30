package org.example.commons;

import java.time.* ;

import org.example.commons.Enums.DepositStatus;

import lombok.Builder;
@Builder
public class DepositAmountResponse {
    private DepositStatus status;
    private Integer accountBalance;
    private String transactionId;
    private LocalDateTime transactionDateAndTime ;
    private Integer transactionAmount;
}
