package org.example.commons;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountBalanceResponse {
    private Integer balance;
}
