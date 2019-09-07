package com.search.radius.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.search.radius.resources.Property;
import com.search.radius.services.PropertyService;

@Controller
public class PropertySearchController {

	@Autowired
	PropertyService propertyService;

	@GetMapping(value = "/")
	public String homePage(Model model) {
		propertyService.create(new Property(0, 0, 1000, 2, 2));
		propertyService.create(new Property(0, 0, 1000, 2, 2));
		propertyService.create(new Property(0, 1, 2000, 3, 2));
		propertyService.create(new Property(1, 0, 3000, 3, 3));
		propertyService.create(new Property(1, 1, 4000, 4, 2));
		model.addAttribute("appName", "Radius Search");
		return "home";
	}

	@GetMapping(value = "/all")
	public String getAll(Model model) {
		model.addAttribute("properties", Arrays.asList(propertyService.findOne("0")));
		return "a";
	}

	@PostMapping(value = "/property")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {

		propertyService.create(property);
		return new ResponseEntity<Property>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/property/{id}")
	@ResponseBody
	public Property getProperty(@PathVariable("id") String id) {

		return propertyService.findOne(id);

	}
	
	@GetMapping(value = "/Property", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Property getProperties() {
		return propertyService.findOne("0");
	}

}
