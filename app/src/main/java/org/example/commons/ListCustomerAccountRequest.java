package org.example.commons;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ListCustomerAccountRequest extends AuthenticatedRequest {
    private String customerId;
}
