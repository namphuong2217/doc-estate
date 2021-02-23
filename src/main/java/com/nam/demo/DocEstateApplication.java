package com.nam.demo;

import com.nam.demo.model.User;
import com.nam.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DocEstateApplication { // implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DocEstateApplication.class, args);
	}


	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

//	@Override
//	public void run(String... args) throws Exception {
//
//		User user = new User();
//		user.setUsername("admin");
//		user.setEmail("admin2@gmail.com");
//		user.setPassword(passwordEncoder.encode("admin"));
//		userRepository.save(user);
//		System.out.println(user);
//	}

}
