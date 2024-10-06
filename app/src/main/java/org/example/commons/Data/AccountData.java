package org.example.commons.Data;
import lombok.Builder; 
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate ;

@Builder 
@Getter
@Setter
public class AccountData {
    private String accountNumber ;
    private String accountId ;
    private String customerId ;
    private LocalDate createdDate ;
    private Integer currentbalance ;
}
