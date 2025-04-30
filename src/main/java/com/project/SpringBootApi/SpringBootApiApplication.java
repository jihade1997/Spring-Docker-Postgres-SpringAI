package com.project.SpringBootApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}

	@GetMapping
	public String HelloMethod(){
		return "Hello World !";
	}
}
