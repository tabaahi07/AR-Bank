package org.example.commons;

import lombok.Builder;

@Builder
public class CustomerLoginRequest {
    private String userId;
    private String passwd;
}
