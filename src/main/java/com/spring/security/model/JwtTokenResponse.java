package com.spring.security.model;

public class JwtTokenResponse {
    private final String jwtToken;

    public JwtTokenResponse(String token) {
        this.jwtToken = token;
    }
}
