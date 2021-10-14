package com.bridgelabz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bridgelabz.demo")
@EnableJpaRepositories("com.bridgelabz.demo.repository")
@EnableEurekaClient
public class UserRegistration1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistration1Application.class, args);
	}

}
