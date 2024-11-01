package org.example.commons;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AccountBalanceRequest extends AuthenticatedRequest {
    private String accountNumber ;
}
