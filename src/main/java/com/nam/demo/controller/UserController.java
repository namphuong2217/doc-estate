package com.nam.demo.controller;

import com.nam.demo.dto.RegisterRequest;
import com.nam.demo.dto.UserDTO;
import com.nam.demo.model.User;
import com.nam.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<?> getUser(@PathVariable String name){
        Optional<UserDTO> userDTO = userService.findUserByName(name);
        if (userDTO != null)
            return ResponseEntity.ok().body(userDTO);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // return all users with all information without password
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }

    @DeleteMapping("/user/{name}")
    public ResponseEntity<?> deleteUser(@PathVariable String name){
        userService.deleteUser(name);
        return ResponseEntity.ok().body("User deleted");
    }

}
