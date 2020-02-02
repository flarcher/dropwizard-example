package flarcher.pairing.http;

import flarcher.pairing.http.resource.TournamentResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PairingApplication extends Application<PairingConfiguration> {

	@Override
	public String getName() {
		return "Table-Pairing-App";
	}

	@Override
	public void initialize(Bootstrap<PairingConfiguration> bootstrap) {
		System.out.println("Initializing");
	}

	@Override
	public void run(PairingConfiguration configuration, Environment environment) throws Exception {
		System.out.println("Running");
		int defaultTableCount = configuration.getDefaultTableCount();
		environment.jersey().register(new TournamentResource(defaultTableCount));
		environment.healthChecks().register("configuration", new PairingConfigurationHealthCheck(defaultTableCount));
	}
}
