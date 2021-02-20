package com.nam.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Register Request must give a name")
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;
    @NotBlank( message = "Register Request Email can not be empty")
    @Email
    private String email; // throws already exist exception
    @NotBlank( message = "Register Request Password can not be empty")
    private String password;
}
