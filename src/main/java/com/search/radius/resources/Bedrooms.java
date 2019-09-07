package com.search.radius.resources;

public class Bedrooms {
	
	private int min;
	
	public Bedrooms(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	private int max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
