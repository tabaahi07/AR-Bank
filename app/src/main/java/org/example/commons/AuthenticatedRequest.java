package org.example.commons;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class AuthenticatedRequest {
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
