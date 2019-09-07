package com.search.radius.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.search.radius.resources.Property;
import com.search.radius.resources.Requirement;
import com.search.radius.services.PropertyService;
import com.search.radius.services.PropertyValidator;
import com.search.radius.services.RequirementRepositoryService;

@Controller
public class PropertySearchController {

	@Autowired
	PropertyService propertyService;

	@Autowired
	private RequirementRepositoryService requirementRepo;

	@Autowired
	PropertyValidator propertyValidator;

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

	@GetMapping(value = "/property", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Property> searchProperties(@RequestParam("filters") String filters) {

		// Encoding format '&' = '%26' and '=' = '%3D' as per TMF alignment

		Requirement requirement = propertyValidator.validateAndSetRequirement(filters);
		if (requirement != null) {
			requirementRepo.createRequirement(requirement);
		}

		return propertyService.findProperties(requirement);
	}

}
