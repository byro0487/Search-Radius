package com.search.radius.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.search.radius.resources.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, String> {

}
