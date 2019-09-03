package com.search.radius.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.search.radius.repository.PropertyRepository;

@Configuration
@EnableCouchbaseRepositories(basePackageClasses = PropertyRepository.class)
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("localhost");
	}

	@Override
	protected String getBucketName() {
		return "default";
	}

	@Override
	protected String getBucketPassword() {
		return "Administrator";
	}

	@Override
	protected String getUsername() {
		return "Administrator";
	}

}
