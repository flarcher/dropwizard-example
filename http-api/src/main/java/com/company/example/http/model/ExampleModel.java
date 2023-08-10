package com.company.example.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExampleModel {

	public ExampleModel() {}

	@JsonProperty("config_value")
	private int configurationValue;

	@JsonProperty("app_value")
        private int applicationValue;
        
	public int getConfiguredValue() {
		return configurationValue;
	}

	public void setConfiguredValue(int count) {
		this.configurationValue = count;
	}

	public int getApplicationValue() {
		return applicationValue;
	}

	public void setApplicationValue(int applicationValue) {
		this.applicationValue = applicationValue;
	}
}
