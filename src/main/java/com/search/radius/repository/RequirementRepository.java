package com.search.radius.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.search.radius.resources.Requirement;

@Repository
public interface RequirementRepository extends CrudRepository<Requirement, String> {

}
