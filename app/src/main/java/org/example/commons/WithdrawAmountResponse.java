package org.example.commons;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.example.commons.Enums.WithdrawStatus;

@Builder
public class WithdrawAmountResponse {
    private WithdrawStatus withdrawStatus ;
    private String message;
    private Integer accountBalance;
    private String transactionId;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private Integer transactionAmount;
}
