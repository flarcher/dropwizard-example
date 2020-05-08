package com.company.example.http;

import com.company.example.http.resource.ExampleResource;
import io.dropwizard.Application;
import io.dropwizard.lifecycle.ServerLifecycleListener;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import java.util.Arrays;
import java.util.function.Consumer;

public class ExampleApplication extends Application<ExampleConfiguration> {

	public ExampleApplication(Consumer<Integer> configurationReader) {
		this.onStart = configurationReader;
	}

	private final Consumer<Integer> onStart;

	@Override
	public String getName() {
		return "Application example name";
	}

	@Override
	public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
		System.out.println("Initializing");
	}

	@Override
	public void run(ExampleConfiguration configuration, Environment environment) throws Exception {

		environment.lifecycle().addServerLifecycleListener(new ServerLifecycleListener() {

			@Override
			public void serverStarted(Server server) {
				Arrays.stream(server.getConnectors())
						.filter(connector -> connector instanceof ServerConnector)
						.map(connector -> ((ServerConnector) connector).getLocalPort())
						.forEach(onStart);
			}
		});

		int defaultTableCount = configuration.getDefaultCount();
		environment.jersey().register(new ExampleResource(defaultTableCount));
		environment.jersey().register(new CORS_ResponseFilter());
		environment.healthChecks().register("configuration", new ExampleHealthCheck(defaultTableCount));
	}
}
