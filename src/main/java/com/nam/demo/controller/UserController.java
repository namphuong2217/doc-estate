package com.nam.demo.controller;

import com.nam.demo.dto.RegisterRequest;
import com.nam.demo.dto.UserDTO;
import com.nam.demo.exception.RecordNotFoundException;
import com.nam.demo.exception.ResourceAlreadyExistsException;
import com.nam.demo.model.User;
import com.nam.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;

    // Task 1: Add new user
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest registerRequest) {
        if(userService.emailExisted(registerRequest.getEmail()))
            throw new ResourceAlreadyExistsException("Email already registered");
        userService.register(registerRequest);
        return ResponseEntity.ok("User has been registered successfully");
    }

    // Task 2: Query a user with name
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.findUserById(id);
        if (userDTO == null)
            throw new RecordNotFoundException("User with given id not found: " + id);
        return ResponseEntity.ok().body(userDTO);

    }

    // Task 3: Return all users with all information without password
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    // Task 4: Delete a user by id
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable @Valid Long id) {
        UserDTO userDTO = userService.findUserById(id);
        if (userDTO == null)
            throw new RecordNotFoundException("User with given id not found: " + id + ", cannot delete user");
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User has been deleted successfully");
    }
}
