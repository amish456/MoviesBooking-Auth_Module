package com.auth;

import com.auth.model.Role;
import com.auth.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(RoleRepository repo) {
		return args -> {
			repo.save(new Role(1L, "ROLE_ADMIN"));
			repo.save(new Role(2L, "ROLE_USER"));
		};
	}

}
