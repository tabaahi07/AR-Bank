package org.example.commons;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AddCustomerAccountRequest extends AuthenticatedRequest {
    private String customerId;
}
