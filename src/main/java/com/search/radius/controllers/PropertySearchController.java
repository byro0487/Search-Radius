package com.search.radius.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.search.radius.resources.Property;
import com.search.radius.services.PropertyService;

@Controller
public class PropertySearchController {
	
	@Autowired
	PropertyService propertyService;

	List<Property> props = new ArrayList<Property>();
	{
		
		props.add(new Property(0, 0, 1000, 2, 2));
		props.add(new Property(0, 1, 2000, 3, 2));
		props.add(new Property(1, 0, 3000, 3, 3));
		props.add(new Property(1, 1, 4000, 4, 2));
	}

	@GetMapping(value = "/getProperties")
	public List<Property> getProperties() {
		propertyService.create(new Property(0, 0, 1000, 2, 2));
		return  propertyService.findAll();
	}

}
