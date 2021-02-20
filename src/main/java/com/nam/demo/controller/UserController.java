package com.nam.demo.controller;

import com.nam.demo.dto.LoginRequest;
import com.nam.demo.dto.LoginResponse;
import com.nam.demo.dto.RegisterRequest;
import com.nam.demo.dto.UserDTO;
import com.nam.demo.exception.RecordNotFoundException;
import com.nam.demo.exception.ResourceAlreadyExistsException;
import com.nam.demo.security.CustomUserDetails;
import com.nam.demo.security.JwtProvider;
import com.nam.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    // Spring Security implementation
    @Autowired
    AuthenticationManager authenticationManager;

    // Spring Security implementation
    @Autowired
    private JwtProvider jwtProvider;

    // Task 1: Add new user. If email is not unique, throw exception
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest registerRequest) {
        if(userService.emailExisted(registerRequest.getEmail()))
            throw new ResourceAlreadyExistsException("Email already registered");
        userService.register(registerRequest);
        return ResponseEntity.ok("User has been registered successfully");
    }

    // Task 2: Query a user with id. If User Id does not exist, throw exception
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.findUserById(id);
        if (userDTO == null)
            throw new RecordNotFoundException("User with given id not found: " + id);
        return ResponseEntity.ok().body(userDTO);

    }

    // Task 3: Return all users with all information without password, using UserDTO
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    // Task 4: Delete a user by id. If User Id does not exist, throw exception
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable @Valid Long id) {
        UserDTO userDTO = userService.findUserById(id);
        if (userDTO == null)
            throw new RecordNotFoundException("User with given id not found: " + id + ", cannot delete user");
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User has been deleted successfully");
    }

    // Aufgabe 3 Application of Spring Security JWT
    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest){

        // authenticate username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // no exception means authentication valid, set authentication into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // response with JWT
        String jwt = jwtProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
}
