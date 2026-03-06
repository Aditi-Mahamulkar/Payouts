package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.example.Entity")

public class PayoutsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayoutsApiApplication.class, args);
	}

}
