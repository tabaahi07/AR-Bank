package org.example.commons;
import java.time.LocalDate;
import java.time.LocalTime;
import org.example.commons.Enums.DepositStatus;
import lombok.Builder;

@Builder
public class DepositAmountResponse {
    private DepositStatus status;
    private String message;
    private Integer accountBalance;
    private String transactionId;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private Integer transactionAmount;
}
