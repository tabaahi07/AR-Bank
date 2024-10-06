package org.example.commons;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public class AddCustomerDetailsResponse {
    private String customerId ;
    private String defaultPassword ;
}
