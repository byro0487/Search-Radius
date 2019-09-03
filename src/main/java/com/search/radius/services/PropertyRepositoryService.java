package com.search.radius.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.stereotype.Service;

import com.search.radius.repository.PropertyRepository;
import com.search.radius.resources.Property;

@Service
public class PropertyRepositoryService implements PropertyService {

	@Autowired
	private PropertyRepository repo;

	@Override
	public Property findOne(String id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Property> findAll() {
        List<Property> properties = new ArrayList<Property>();
        Iterator<Property> it = repo.findAll().iterator();
        while(it.hasNext()) {
        	properties.add(it.next());
        }
        return properties;
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
		repo.delete(property);
	}

}
