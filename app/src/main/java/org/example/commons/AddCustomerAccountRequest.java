package org.example.commons;
import lombok.*;

@Getter
@Data
public class AddCustomerAccountRequest {
    private String customerId;
    private String accessToken ;
}
