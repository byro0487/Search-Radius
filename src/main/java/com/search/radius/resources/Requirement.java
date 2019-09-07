package com.search.radius.resources;

import com.couchbase.client.java.repository.annotation.Field;

public class Requirement {

	String Id;

	@Field
	private float longitude;

	@Field
	private float latitude;
	@Field
	private Budget budget;
	@Field
	private Bedrooms bedrooms;
	@Field
	private Bathrooms bathrooms;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public Bedrooms getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(Bedrooms bedrooms) {
		this.bedrooms = bedrooms;
	}
	public Bathrooms getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(Bathrooms bathrooms) {
		this.bathrooms = bathrooms;
	}

}
