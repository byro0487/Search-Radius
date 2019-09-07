package com.search.radius.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.search.radius.resources.Requirement;

public class PropertyValidator {

	Set<String> validValues = new HashSet<>();

	public void addValidValues() {

		validValues.add("latitude");
		validValues.add("longitude");
		validValues.add("minBudget");
		validValues.add("maxBudget");
		validValues.add("minBedrooms");
		validValues.add("maxBedrooms");
		validValues.add("minBathrooms");
		validValues.add("maxBathrooms");

	}

	public Requirement validateAndSetRequirement(String filters) {

		addValidValues();

		if (filters == null || filters.isEmpty()) {
			System.out.println("Filters is empty");
		}

		List<String> propertiesKeyValue = new ArrayList<>();

		propertiesKeyValue.addAll(Arrays.asList(filters.split("&")));

		List<String> properties = new ArrayList<>();

		for (String property : propertiesKeyValue) {
			properties.addAll(Arrays.asList(property.split("==")));

		}
		Requirement r = new Requirement();
		boolean isValid = true;

		for (int i = 0; i < properties.size(); i = i + 2) {

			if (!validValues.contains(properties.get(i))) {
				System.out.println("Filters key is not valid");
				System.out.println("Valid filter values are :" + validValues.toString());
				isValid = false;
				break;
			} else {

				if (properties.get(i).equals("latitude")) {
					r.setLatitude(Float.parseFloat(properties.get(i + 1)));

				} else if (properties.get(i).equals("longitude")) {
					r.setLongitude(Float.parseFloat(properties.get(i + 1)));

				}

				else if (properties.get(i).equals("minBudget")) {
					r.setMinBudget(Integer.parseInt(properties.get(i + 1)));

				}

				else if (properties.get(i).equals("maxBudget")) {
					r.setMaxBudget(Integer.parseInt(properties.get(i + 1)));

				}

				else if (properties.get(i).equals("minBedrooms")) {
					r.setMinBedrooms(Integer.parseInt(properties.get(i + 1)));

				}

				else if (properties.get(i).equals("maxBedrooms")) {
					r.setMaxBedrooms(Integer.parseInt(properties.get(i + 1)));

				}

				else if (properties.get(i).equals("maxBathrooms")) {
					r.setMaxBathrooms(Integer.parseInt(properties.get(i + 1)));

				}

				else if (properties.get(i).equals("minBathrooms")) {
					r.setMinBathrooms(Integer.parseInt(properties.get(i + 1)));

				}

			}

		}

		if (isValid) {

			return r;
		} else {
			return null;

		}
	}
}