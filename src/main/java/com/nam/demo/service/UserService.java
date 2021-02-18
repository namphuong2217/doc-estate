package com.nam.demo.service;

import com.nam.demo.dto.RegisterRequest;
import com.nam.demo.dto.UserDTO;
import com.nam.demo.model.User;
import com.nam.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Task 1 handle persistence new user to database
    @Transactional
    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode((registerRequest.getPassword())));

        userRepository.save(user);
    }

    // Task 2 find user by name
    public Optional<UserDTO> findUserByName(String name) {
        User user = userRepository.findByName(name).orElse(null);
        return Optional.ofNullable(mapToUserDTO(user));

    }

    // Task 3 find all users, return a list
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToUserDTO)
                .collect(toList());
    }

    // Task 3 helper function to remove password from response data
    private UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }

    // Task 4 delete user by name
    @Transactional
    public void deleteUser(String name) {
        userRepository.deleteByName(name);
    }
}