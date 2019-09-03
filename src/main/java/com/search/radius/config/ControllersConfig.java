package com.search.radius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.search.radius.controllers.PropertySearchController;

@Configuration
public class ControllersConfig {

	@Bean
	public PropertySearchController getPropertySearchController() {
		return new PropertySearchController();
	}
	
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("templates/");
        //resolver.setSuffix(".html");
        return resolver;
    }

}
