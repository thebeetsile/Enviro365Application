package com.enviro.assessment.grad001.thebeetsileaaronlekomanyane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.repository")
@EntityScan(basePackages = "com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model")
public class Enviro365Application {
	public static void main(String[] args) {
		SpringApplication.run(Enviro365Application.class, args);
		System.out.println("server started.......");
	}
}
