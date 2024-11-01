package org.example.commons;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AddCustomerAccountRequest extends AuthenticatedRequest {
    private String customerId;
}
