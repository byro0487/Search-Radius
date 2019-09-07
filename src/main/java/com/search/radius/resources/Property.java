package com.search.radius.resources;

import javax.validation.constraints.NotNull;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;
import org.springframework.data.couchbase.core.mapping.id.IdSuffix;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE, delimiter = ".")
	private String id;

	@IdPrefix(order = 0)
	private String userPrefix = "Property";

	@IdSuffix(order = 0)
	private String userSuffix;

	@Field
	@NotNull
	private float longitude;

	@Field
	@NotNull
	private float latitude;

	@Field
	@NotNull
	private float price;

	@Field
	@NotNull
	private int bedRooms;

	public Property(float longitude, float latitude, float price, int bedRooms, int bathRooms) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.price = price;
		this.bedRooms = bedRooms;
		this.bathRooms = bathRooms;
	}

	public Property() {
		// default constructor
	}

	private int bathRooms;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getBedRooms() {
		return bedRooms;
	}

	public void setBedRooms(int bedRooms) {
		this.bedRooms = bedRooms;
	}

	public int getBathRooms() {
		return bathRooms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bathRooms;
		result = prime * result + bedRooms;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((userPrefix == null) ? 0 : userPrefix.hashCode());
		result = prime * result + ((userSuffix == null) ? 0 : userSuffix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (bathRooms != other.bathRooms)
			return false;
		if (bedRooms != other.bedRooms)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (userPrefix == null) {
			if (other.userPrefix != null)
				return false;
		} else if (!userPrefix.equals(other.userPrefix))
			return false;
		if (userSuffix == null) {
			if (other.userSuffix != null)
				return false;
		} else if (!userSuffix.equals(other.userSuffix))
			return false;
		return true;
	}

	public void setBathRooms(int bathRooms) {
		this.bathRooms = bathRooms;
	}

}
