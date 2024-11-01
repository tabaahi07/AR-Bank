package org.example.commons;

import org.example.commons.Enums.TransactionType;

import lombok.Getter;

@Getter
public class SetAccountBalanceRequest {
    private String accountNumber ;
    private Integer amount;
    private TransactionType transactionType ; 
}
