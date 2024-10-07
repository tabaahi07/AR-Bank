package org.example.commons;
import lombok.*;

@Getter
public class WithdrawAmountRequest extends AuthenticatedRequest {
    private String accountId;
    private Integer amount;
}
