package com.nam.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Must give a name")
    private String name;
    @NotBlank( message = "Email can not be empty")
    @Email
    private String email;
    @NotBlank( message = "Password can not be empty")
    private String password;
}
