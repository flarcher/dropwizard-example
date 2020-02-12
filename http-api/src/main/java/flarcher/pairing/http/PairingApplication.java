package flarcher.pairing.http;

import flarcher.pairing.http.resource.TournamentResource;
import io.dropwizard.Application;
import io.dropwizard.lifecycle.ServerLifecycleListener;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import java.util.Arrays;
import java.util.function.Consumer;

public class PairingApplication extends Application<PairingConfiguration> {

	public PairingApplication(Consumer<Integer> configurationReader) {
		this.onStart = configurationReader;
	}

	private final Consumer<Integer> onStart;

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

		environment.lifecycle().addServerLifecycleListener(new ServerLifecycleListener() {

			@Override
			public void serverStarted(Server server) {
				Arrays.stream(server.getConnectors())
						.filter(connector -> connector instanceof ServerConnector)
						.map(connector -> ((ServerConnector) connector).getLocalPort())
						.forEach(onStart);
			}
		});

		int defaultTableCount = configuration.getDefaultTableCount();
		environment.jersey().register(new TournamentResource(defaultTableCount));
		environment.jersey().register(new CORS_ResponseFilter());
		environment.healthChecks().register("configuration", new PairingConfigurationHealthCheck(defaultTableCount));
	}
}
