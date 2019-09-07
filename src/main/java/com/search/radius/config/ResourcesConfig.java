package com.search.radius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.search.radius.resources.Property;
import com.search.radius.resources.Requirement;

@Configuration
public class ResourcesConfig {

	@Bean
	public Property getProperty() {
		return new Property();
	}

	@Bean
	public Requirement getRequirement() {
		return new Requirement();
	}
}
