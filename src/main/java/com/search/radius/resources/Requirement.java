package com.search.radius.resources;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Requirement {

	@Id
	@Field
	String id;
	@Field
	private double longitude;
	@Field
	private double latitude;
	@Field
	private int minBudget;
	@Field
	private int maxBudget;
	@Field
	private int minBedrooms;
	@Field
	private int maxBedrooms;
	@Field
	private int minBathrooms;
	@Field
	private int maxBathrooms;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public int getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(int minBudget) {
		this.minBudget = minBudget;
	}

	public int getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}

	public int getMinBedrooms() {
		return minBedrooms;
	}

	public void setMinBedrooms(int minBedrooms) {
		this.minBedrooms = minBedrooms;
	}

	public int getMaxBedrooms() {
		return maxBedrooms;
	}

	public void setMaxBedrooms(int maxBedrooms) {
		this.maxBedrooms = maxBedrooms;
	}

	public int getMinBathrooms() {
		return minBathrooms;
	}

	public void setMinBathrooms(int minBathrooms) {
		this.minBathrooms = minBathrooms;
	}

	public int getMaxBathrooms() {
		return maxBathrooms;
	}

	public void setMaxBathrooms(int maxBathrooms) {
		this.maxBathrooms = maxBathrooms;
	}

}