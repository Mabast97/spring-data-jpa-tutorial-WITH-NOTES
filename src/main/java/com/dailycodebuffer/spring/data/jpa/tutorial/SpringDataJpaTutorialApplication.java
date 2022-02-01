package com.dailycodebuffer.spring.data.jpa.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaTutorialApplication {

	public static void main(String[] args) {
		System.out.printf("Before");
		SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
		System.out.printf("After");
	}

}
