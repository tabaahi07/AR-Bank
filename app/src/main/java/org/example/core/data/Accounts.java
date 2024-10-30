package org.example.core.data;
import lombok.*;
import java.time.*;
import java.util.*;

@Getter
@Builder
@Setter
public class Accounts {
    private String customerId ;
    private String accountNumber ;
    private Integer balance ;
    LocalDate issuedDate ;
}
