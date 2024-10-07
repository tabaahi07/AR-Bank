package org.example.commons;
import lombok.*;

@Getter
public class DepositAmountRequest extends AuthenticatedRequest {
    private String accountId;
    private Integer amount;
}
