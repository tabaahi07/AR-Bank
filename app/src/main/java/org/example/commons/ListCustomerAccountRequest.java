package org.example.commons;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ListCustomerAccountRequest extends AuthenticatedRequest {
    private String customerId;
}
