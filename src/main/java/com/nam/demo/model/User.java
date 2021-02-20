package com.nam.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="my_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Must give a name")
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;
    @NotBlank( message = "Email can not be empty")
    @Email
    private String email;
    @NotBlank( message = "Password can not be empty")
    private String password;
}
