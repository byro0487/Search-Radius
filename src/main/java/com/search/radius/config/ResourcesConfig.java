package com.search.radius.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.search.radius.resources.Property;

@SpringBootConfiguration
public class ResourcesConfig {

	@Bean
	public Property getProperty() {
		return new Property();
	}

}
