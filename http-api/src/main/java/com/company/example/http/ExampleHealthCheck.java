package com.company.example.http;

import com.codahale.metrics.health.HealthCheck;

public class ExampleHealthCheck extends HealthCheck {

	public ExampleHealthCheck(int configurationCount) {
		this.count = configurationCount;
	}

	private final int count;

	@Override
	protected Result check() throws Exception {
		return count > 0
				? Result.healthy()
				: Result.unhealthy("Invalid count");
	}
}
