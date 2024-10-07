package org.example.commons;
import lombok.Getter;

@Getter 
public class ListCustomerAccountRequest extends AuthenticatedRequest {
    private String customerId;
}
