package com.search.radius.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.search.radius.controllers.PropertySearchController;

@SpringBootConfiguration
public class ControllersConfig {

	@Bean
	public PropertySearchController getPropertySearchController() {
		return new PropertySearchController();
	}

}
