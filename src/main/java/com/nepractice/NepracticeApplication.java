package com.nepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@RestController
public class NepracticeApplication {


	public static void main(String[] args) {
		SpringApplication.run(NepracticeApplication.class, args);
		System.out.println("I'm running...");
	}







    // dummy codes
	@GetMapping("/greet")
	public GreetResponse greet(){

		GreetResponse response = new GreetResponse(
				"Hello",
				List.of("Java","GOlang"),
				new Person("AiE",30000,18)
		);
		return response;
	}

	record Person(String name,double cash,int age){
		
	};
	record GreetResponse(
			String greet,
			List<String> favPrograms,
			Person person
	){

	}
}
