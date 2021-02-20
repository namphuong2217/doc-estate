package com.nam.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocEstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocEstateApplication.class, args);
	}

//implements CommandLineRunner
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Override
//	public void run(String... args) throws Exception {
		// Khi chương trình chạy
		// Insert vào csdl một user.
//		User user = new User();
//		user.setUsername("admin");
//		user.setEmail("admin@gmail.com");
//		user.setPassword(passwordEncoder.encode("admin"));
//		userRepository.save(user);
//		System.out.println(user);
//	}

}
