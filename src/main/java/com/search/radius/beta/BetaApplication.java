package com.search.radius.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.search.radius")
public class BetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetaApplication.class, args);
	}

}
