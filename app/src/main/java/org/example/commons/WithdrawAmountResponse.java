package main.java.org.example.commons;

import java.time.LocalDate;
import java.time.LocalTime;
import main.java.org.example.commons.Enums.WithdrawStatus;

public class WithdrawAmountResponse {
    private WithdrawStatus status;
    private String message;
    private Integer accountBalance;
    private String transactionId;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private Integer transactionAmount;
}
