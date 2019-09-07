package com.search.radius.services;

import java.util.List;

import com.search.radius.resources.Property;
import com.search.radius.resources.Requirement;

public interface PropertyService {

	Property findOne(String id);

	List<Property> findProperties(Requirement requirement);

	void create(Property property);

}
