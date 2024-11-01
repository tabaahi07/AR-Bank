package org.example.commons;

import java.time.* ;

import org.example.commons.Enums.TransactionStatus;

import lombok.*;

@Builder
@Data
public class SetAccountBalanceResponse {
    private TransactionStatus status ;
    private String transactionId ;
    private LocalDateTime transactionDateAndTime ;
    private Integer transactionAmount ;
}
