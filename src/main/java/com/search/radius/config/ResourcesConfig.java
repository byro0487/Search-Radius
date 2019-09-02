package com.search.radius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.search.radius.resources.Property;

@Configuration
public class ResourcesConfig {

	@Bean
	public Property getProperty() {
		return new Property();
	}

}
