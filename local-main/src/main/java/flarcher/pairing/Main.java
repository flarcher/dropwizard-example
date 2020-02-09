package flarcher.pairing;

import com.google.common.base.Preconditions;
import flarcher.pairing.http.PairingApplication;

import java.awt.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws Exception {
		// Starts the API
		new PairingApplication().run(args);

		// Show the web-page
		//Path currentPath = Paths.get(".").toAbsolutePath();
		URL currentLocation = Main.class.getProtectionDomain().getCodeSource().getLocation();
		Path currentPath = Paths.get(currentLocation.toURI()).getParent();
		Preconditions.checkState(currentPath.toFile().isDirectory());
		Desktop.getDesktop().open(currentPath.resolve("loading.html").toFile());
	}

}
