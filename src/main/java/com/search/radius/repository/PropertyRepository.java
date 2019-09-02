package com.search.radius.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.search.radius.resources.Property;

public interface PropertyRepository extends CrudRepository<Property, String> {

	List<Property> findByPrice(String price);

}
