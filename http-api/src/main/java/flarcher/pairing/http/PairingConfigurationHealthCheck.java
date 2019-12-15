package flarcher.pairing.http;

import com.codahale.metrics.health.HealthCheck;

public class PairingConfigurationHealthCheck extends HealthCheck {

	public PairingConfigurationHealthCheck(int defaultTableCount) {
		this.defaultTableCount = defaultTableCount;
	}

	private final int defaultTableCount;

	@Override
	protected Result check() throws Exception {
		return defaultTableCount > 0
				? Result.healthy()
				: Result.unhealthy("Invalid default table count");
	}
}
