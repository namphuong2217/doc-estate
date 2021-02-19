package com.nam.demo.controller;

import com.nam.demo.dto.RegisterRequest;
import com.nam.demo.dto.UserDTO;
import com.nam.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
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
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest registerRequest){
        userService.register(registerRequest);
        return ResponseEntity.ok("User register successful");
    }

    // Task 1: handle exception while registering new user, at controller level
    @ExceptionHandler({ ConstraintViolationException.class, MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(Exception e){
        return "Input not valid due to error: " + e.getMessage();
    }

    // Task 2: Query a user with name
    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(userService.findUserById(id));
        } catch(Exception e){
            log.info("Query user not successful: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Id: " + id + " not found");
    }

    // Task 3: Return all users with all information without password
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
//        Array arrayUsers = [];
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    // Task 4: Delete a user by id
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable @Valid Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().body("User deleted");
        } catch(Exception e){
            log.info("Deleted user with id not successful. " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Id not found. Can not delete user with id: " + id);
    }


}
