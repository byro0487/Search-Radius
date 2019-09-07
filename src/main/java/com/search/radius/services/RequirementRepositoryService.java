package com.search.radius.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.search.radius.repository.RequirementRepository;
import com.search.radius.resources.Requirement;

public class RequirementRepositoryService {
	
	@Autowired
	private RequirementRepository repo;
	
	public void createRequirement(Requirement requirement) {
		requirement.setId("Requirement_" + requirement.getLatitude() + "_" + requirement.getLongitude());
		repo.save(requirement);

	}

}
