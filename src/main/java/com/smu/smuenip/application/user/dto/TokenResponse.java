package com.smu.smuenip.application.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponse {

    private final String accessToken;

    @Builder
    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
