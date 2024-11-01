package org.example.core.dto;
import java.time.LocalDateTime;
import org.example.commons.Enums.TransactionStatus;
import org.example.core.data.Accounts;
import java.util.* ;
import lombok.* ;

@Builder
@Getter
public class TransactionReceipt {
    private String transactionId ;
    private TransactionStatus status ;
    private LocalDateTime transactionDateAndTime ;

    private Optional<Accounts> accountDetail ;
}
