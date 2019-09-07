package com.search.radius.resources;

public class Budget {

	private float min;

	private float max;

	public Budget(float min, float max) {
		super();
		this.min = min;
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

}
