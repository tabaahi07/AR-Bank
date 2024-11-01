package org.example.commons;

import java.time.LocalDate;
import lombok.*;

@Builder
@Data
public class AddCustomerDetailsResponse {
    private String customerId;
}
