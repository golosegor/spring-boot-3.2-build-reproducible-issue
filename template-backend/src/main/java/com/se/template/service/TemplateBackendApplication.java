package com.se.template.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateBackendApplication {

	public static void main(String[] args) {
    System.setProperty("spring.config.additional-location", "classpath:application-core.yml");
		SpringApplication.run(TemplateBackendApplication.class, args);
	}

}
