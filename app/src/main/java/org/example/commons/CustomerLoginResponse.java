package org.example.commons;

import org.example.commons.Enums.LoginStatus;

import lombok.Getter;

@Getter
public class CustomerLoginResponse {
    private String accessToken;
    private LoginStatus status;
    private String message;
}
