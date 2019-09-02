package com.search.radius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.search.radius.services.PropertyRepositoryService;
import com.search.radius.services.PropertyService;

@Configuration
public class ServicesConfig {

	@Bean
	public PropertyService getPropertyService() {
		return new PropertyRepositoryService();
	}

}
