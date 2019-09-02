package com.search.radius.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.radius.repository.PropertyRepository;
import com.search.radius.resources.Property;

@Service
public class PropertyRepositoryService implements PropertyService {

	@Autowired
	private PropertyRepository repo;

	@Override
	public Property findOne(String id) {
		return null;
	}

	@Override
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return (List<Property>) repo.findAll();
	}

	@Override
	public List<Property> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Property property) {
		repo.save(property);

	}

	@Override
	public void update(Property property) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Property property) {
		// TODO Auto-generated method stub

	}

}
