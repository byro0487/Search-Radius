package com.search.radius.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.search.radius.config.ControllersConfig;
import com.search.radius.config.MyCouchbaseConfig;
import com.search.radius.config.ResourcesConfig;
import com.search.radius.config.ServicesConfig;

@SpringBootApplication
@ComponentScan(basePackageClasses = { ControllersConfig.class, ResourcesConfig.class, MyCouchbaseConfig.class,
		ServicesConfig.class })
public class BetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetaApplication.class, args);
	}

}
