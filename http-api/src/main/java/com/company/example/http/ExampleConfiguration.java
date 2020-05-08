package com.company.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;

/**
 * Describes the YAML configuration file format.
 */
public class ExampleConfiguration extends Configuration {

	@Min(1L)
	private int defaultCount;

	@JsonProperty
	public int getDefaultCount() {
		return defaultCount;
	}

	@JsonProperty
	public void setDefaultCount(int defaultCount) {
		this.defaultCount = defaultCount;
	}
}
