package com.smu.smuenip.application.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequestDto {

    private String loginId;
    private String password;

}