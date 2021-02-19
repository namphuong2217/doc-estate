package com.nam.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    private String name;
    @NotBlank( message = "Email can not be empty")
    private String email;
    @NotBlank( message = "Password can not be empty")
    private String password;
}
