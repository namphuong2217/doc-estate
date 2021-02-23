package com.nam.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String loginToken;
    private String tokenType = "Bearer";

    public LoginResponse(String loginToken){
        this.loginToken = loginToken;
    }
}
