package flarcher.pairing;

import com.google.common.base.Preconditions;
import flarcher.pairing.http.PairingApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	private static Logger LOGGER;

	public static void main(String[] args) throws Exception {
		Class<?> mainClass = MethodHandles.lookup().lookupClass();
		LOGGER = LoggerFactory.getLogger(mainClass);

		// Opens the web-app immediately
		LOGGER.info("~~~~~ Web application Start ~~~~~~");
		open(mainClass, "index.html");

		// Starts the API
		LOGGER.info("~~~~~ API Start ~~~~~~");
		new PairingApplication().run(args);
	}

	private static void open(Class<?> clazz, String fileName) {
		URL currentLocation = clazz.getProtectionDomain().getCodeSource().getLocation();
		try {
			Path currentPath = Paths.get(currentLocation.toURI()).getParent();
			Preconditions.checkState(currentPath.toFile().isDirectory());
			Desktop.getDesktop().open(currentPath.resolve(fileName).toFile());
		}
		catch (URISyntaxException e) {
			LOGGER.error("Internal error");
		}
		catch (IOException e) {
			LOGGER.error("Impossible to open " + fileName);
		}
	}
}
