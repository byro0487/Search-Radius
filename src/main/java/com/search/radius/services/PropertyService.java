package com.search.radius.services;

import java.util.List;

import com.search.radius.resources.Property;

public interface PropertyService {

	Property findOne(String id);

	List<Property> findAll();

	List<Property> findByFirstName(String firstName);

	void create(Property property);

	void update(Property property);

	void delete(Property property);

}
