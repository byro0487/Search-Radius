package com.search.radius.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = { "com.search.radius.config" })
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("10.238.196.133");
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
