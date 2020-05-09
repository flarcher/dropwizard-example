package com.company.example.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExampleModel {

	public ExampleModel() {
	}

	@JsonProperty("count")
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
