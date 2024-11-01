package org.example.commons;

import lombok.Getter;

@Getter
public class AddCustomerAccountRequest extends AuthenticatedRequest {
    private String customerId;
}
