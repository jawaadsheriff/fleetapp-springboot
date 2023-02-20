package com.sheriff.fleetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class FleetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetappApplication.class, args);
	}

}
