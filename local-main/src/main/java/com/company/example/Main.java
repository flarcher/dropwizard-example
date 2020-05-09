package com.company.example;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import com.company.example.http.ExampleApplication;

public class Main {

	private static Logger LOGGER;

	public static void main(String[] args) throws Exception {
		Class<?> mainClass = MethodHandles.lookup().lookupClass();
		LOGGER = LoggerFactory.getLogger(mainClass);

		Consumer<Integer> onStart = port -> {
			LOGGER.info("~~~~~ Web application Start ~~~~~~");
			open(mainClass, "index.html", Integer.toString(port));
		};

		ExampleApplication serverApp = new ExampleApplication(onStart);
		LOGGER.info("~~~~~ API Start ~~~~~~");
		serverApp.run(args);
	}

	private static void open(Class<?> clazz, String fileName, String query) {
		URI uri = null;
		try {
			uri = clazz.getProtectionDomain().getCodeSource().getLocation().toURI();
			Path currentPath = Paths.get(uri).getParent();
			Preconditions.checkState(currentPath.toFile().isDirectory());
			uri = currentPath.resolve(fileName).toUri();
			if (query != null) {
				// The use of a query param does not work
				// See https://stackoverflow.com/questions/24334436/setting-a-query-string-from-javas-desktop-getdesktop-browseuri-uri
				// new URI("file", "", programPath, "version=1.0.3", "");
				uri = new URI(uri.toString() + "#" + query);
			}
			Desktop.getDesktop().browse(uri);
		}
		catch (URISyntaxException e) {
			LOGGER.error("Internal error");
		}
		catch (IOException e) {
			LOGGER.error("Impossible to open " + uri);
		}
	}
}
