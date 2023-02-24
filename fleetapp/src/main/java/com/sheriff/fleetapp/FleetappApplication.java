package com.sheriff.fleetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class FleetappApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new SecurityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(FleetappApplication.class, args);
	}

}
