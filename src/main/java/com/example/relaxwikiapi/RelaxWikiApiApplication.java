package com.example.relaxwikiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

//main method of the application, starts the springboot application
@SpringBootApplication
public class RelaxWikiApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(RelaxWikiApiApplication.class, args);
	}

}
