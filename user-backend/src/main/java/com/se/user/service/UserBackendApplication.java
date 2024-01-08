package com.se.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserBackendApplication {

	public static void main(String[] args) {
    System.setProperty("spring.config.additional-location", "classpath:application-core.yml");
		SpringApplication.run(UserBackendApplication.class, args);
	}

}
