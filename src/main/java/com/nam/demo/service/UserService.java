package com.nam.demo.service;

import com.nam.demo.dto.RegisterRequest;
import com.nam.demo.dto.UserDTO;
import com.nam.demo.exception.RecordNotFoundException;
import com.nam.demo.exception.ResourceAlreadyExistsException;
import com.nam.demo.model.User;
import com.nam.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Task 1 handle persistence new user to database
    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterRequest registerRequest) {
        try {
            User user = new User();
            user.setName(registerRequest.getName());
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode((registerRequest.getPassword())));

            userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException("Email");
        }
    }

    // Task 2 find user by id
    @Transactional(readOnly = true)
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User with given id not found: " + id));
        log.info("Exception at Service layer: delete by id failed. ");
        return this.mapToUserDTO(user);


    }

    // Task 3 find all users, return a list
    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToUserDTO)
                .collect(toList())
                ;
    }

    // Task 3 helper function to remove password from response data
    private UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }

    // Task 4 delete user by id
    @Transactional
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RecordNotFoundException("User with given id not found: " + id);
        }
    }
}
