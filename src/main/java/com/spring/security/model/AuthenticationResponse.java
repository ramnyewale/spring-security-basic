package com.spring.security.model;

public class AuthenticationResponse {
    private final String jwtToken;

    public AuthenticationResponse(String token) {
        this.jwtToken = token;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
