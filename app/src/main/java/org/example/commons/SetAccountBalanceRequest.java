package org.example.commons;

import org.example.commons.Enums.TransactionType;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class SetAccountBalanceRequest {
    private String accountNumber ;
    private Integer amount;
    private TransactionType transactionType ; 
}
