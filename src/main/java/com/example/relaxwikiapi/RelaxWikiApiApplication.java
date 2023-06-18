package com.example.relaxwikiapi;

import com.example.relaxwikiapi.dto.RegisterRequest;
import com.example.relaxwikiapi.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import static com.example.relaxwikiapi.entity.Role.ADMIN;
import static com.example.relaxwikiapi.entity.Role.USER;


//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

//main method of the application, starts the springboot application
@SpringBootApplication
public class RelaxWikiApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(RelaxWikiApiApplication.class, args);
	}
//
//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	) {
//		return args -> {
//			var admin = RegisterRequest.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("admin@mail.com")
//					.password("password")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: " + service.register(admin).getAccessToken());
//
//			var manager = RegisterRequest.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("manager@mail.com")
//					.password("password")
//					.role(USER)
//					.build();
//			System.out.println("Manager token: " + service.register(manager).getAccessToken());
//
//		};
//	}
}
