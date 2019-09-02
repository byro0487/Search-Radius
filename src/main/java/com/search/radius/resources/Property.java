package com.search.radius.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "longitude cannot be empty")
	private float longitude;
	
	@NotBlank(message = "latitude cannot be empty")
	private float latitude;
	
	@NotBlank(message = "price cannt be empty")
	private float price;
	
	@NotBlank(message = "bedrooms cannot be empty")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setBathRooms(int bathRooms) {
		this.bathRooms = bathRooms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bathRooms;
		result = prime * result + bedRooms;
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + Float.floatToIntBits(price);
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
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

}
