package flarcher.pairing.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;

/**
 * Describes the YAML configuration file format.
 */
public class PairingConfiguration extends Configuration {

	@Min(1L)
	private int defaultTableCount;

	@JsonProperty
	public int getDefaultTableCount() {
		return defaultTableCount;
	}

	@JsonProperty
	public void setDefaultTableCount(int defaultTableCount) {
		this.defaultTableCount = defaultTableCount;
	}
}
