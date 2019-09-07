package com.search.radius.services;

import static com.couchbase.client.java.query.dsl.Expression.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonGenerationException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.DeserializationFeature;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonMappingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.query.ParameterizedN1qlQuery;
import com.couchbase.client.java.query.Select;
import com.couchbase.client.java.query.Statement;
import com.search.radius.repository.PropertyRepository;
import com.search.radius.resources.Property;
import com.search.radius.resources.Requirement;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository repo;

	// Find property based on id.
	@Override
	public Property findOne(String id) {
		return repo.findById(id).get();
	}

	// Search properties based on requirement criteria.
	@Override
	public List<Property> findProperties(Requirement requirement) {

		List<N1qlQueryRow> results = clusterSetupAndQueryFormation(requirement);
		List<Property> list = createObjectsFromJson(results);

		return filterBasedOnDistance(list, requirement);
	}

	// Add property resource.
	@Override
	public void create(Property property) {
		
		// set id based on the input parameters
		property.setId("Property_" + property.getLongitude() + "_" + property.getLatitude());

		// calling repository service to save in DB
		repo.save(property);
	}

	// Helper method to filter properties based on distance.
	private List<Property> filterBasedOnDistance(List<Property> list, Requirement requirement) {
		int i = 0;
		while (i < list.size()) {
			Property property = list.get(i);
			double distance = getDistanceFromLatLonInMiles(property.getLatitude(), property.getLongitude(),
					requirement.getLatitude(), requirement.getLongitude());
			if (distance <= 10.0) {
				i++;
			} else {
				list.remove(i);
			}
		}
		return list;

	}

	// Cluster and query formation.
	private List<N1qlQueryRow> clusterSetupAndQueryFormation(Requirement requirement) {

		System.setProperty("com.couchbase.queryEnabled", "true");

		Cluster cluster = CouchbaseCluster.create().authenticate("Administrator", "Administrator");

		Bucket bucket = cluster.openBucket("default");

		Statement statement = Select.select("*").from("default")
				.where((x("price").gte("$minBudget").or(x("price").lte("$maxBudget")))
						.and((x("bedRooms").gte("$minBedrooms")).or(x("bedRooms").lte("$maxBedrooms")))
						.and((x("bathRooms").gte("$minBathrooms")).or(x("bathRooms").lte("$maxBathrooms"))));

		JsonObject placeHolderValues = JsonObject.create().put("minBudget", requirement.getMinBudget())
				.put("maxBudget", requirement.getMaxBudget()).put("minBedrooms", requirement.getMinBedrooms())
				.put("maxBedrooms", requirement.getMaxBedrooms()).put("minBathrooms", requirement.getMinBathrooms())
				.put("maxBathrooms", requirement.getMaxBathrooms());

		ParameterizedN1qlQuery q = N1qlQuery.parameterized(statement, placeHolderValues);

		return bucket.query(q).allRows();

	}

	// Helper method used for calculating the distance based on latitude and longitude.
	private double getDistanceFromLatLonInMiles(double lat1, double lon1, double lat2, double lon2) {
		double R = 3958.8; // Radius of the earth in miles
		double dLat = deg2rad(lat2 - lat1); // deg2rad below
		double dLon = deg2rad(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c; // Distance in miles
		return d;
	}

	// Helper method for calculating distance.
	private double deg2rad(double deg) {
		return deg * (Math.PI / 180);
	}

	// Create property based on query results.
	private List<Property> createObjectsFromJson(List<N1qlQueryRow> results) {

		List<Property> list = new ArrayList<Property>();

		for (N1qlQueryRow n1qlQueryRow : results) {

			JsonObject obj = n1qlQueryRow.value();
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			try {
				list.add(mapper.readValue(obj.get("default").toString(), Property.class));
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

}
