package org.example.commons;
import lombok.*;

@Getter
public class AccountBalanceRequest extends AuthenticatedRequest {
    private String accountId;
}
