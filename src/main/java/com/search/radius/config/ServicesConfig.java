package com.search.radius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.search.radius.services.PropertyService;
import com.search.radius.services.PropertyServiceImpl;
import com.search.radius.services.PropertyValidator;
import com.search.radius.services.RequirementRepositoryService;

@Configuration
public class ServicesConfig {

	@Bean
	public PropertyService getPropertyService() {
		return new PropertyServiceImpl();
	}

	@Bean
	public PropertyValidator getPropertyValidator() {
		return new PropertyValidator();
	}

	@Bean
	public RequirementRepositoryService getRequirementService() {
		return new RequirementRepositoryService();
	}

}
