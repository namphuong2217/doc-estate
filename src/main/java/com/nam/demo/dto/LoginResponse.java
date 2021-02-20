package com.nam.demo.dto;

public class LoginResponse {
    private String loginToken;
    private String tokenType = "Bearer";

    public LoginResponse(String loginToken){
        this.loginToken = loginToken;
    }
}
