# Dropwizard usage example

It includes:
* An HTTP API implemented using [DropWizard](https://www.dropwizard.io/en/latest/)
* Example of a JSON model bound to the API
* A very simple web application using this API
* The use of main [DropWizard](https://www.dropwizard.io/en/latest/) features like the use of the configuration file, logging, health-check, banner, ...
* A packaging that delivers ready-to-run binary for Windows and Unix based operating systems (with embedded dependencies and start scripts)
* A split of the code into meaningfull maven modules

## Dependencies

* It needs a *Java Runtime Environment* version 8+ for the API.
* An *evergreen / modern* web browser (not IE)

## Build

Run `mvn install`

## How to see it working

* Go to the `target` sub-directory
* Execute either `start.sh` from Linux or MacOS, or `start.bat` from Windows.
* If a web page is not opened automatically or if it shows an error, please go to the URL file://target/index.html#8000 (with the hash) (this issue can occur when using Windows)

## Contributing

In order to build the project, you will need:
* A *JDK* version 8+
* [Apache Maven](https://maven.apache.org/)

Instead of using the provided start scripts, you can also run the server with the following command:

    java -jar target/app.jar server target/configuration.yml

This server will deploy an API accessible from [http://localhost:8000/api](http://localhost:8000/api) by default.

The API port can be configured as the attribute `server.connecter.port` in the configuration file.

## License

This project is using the [Apache2](https://www.apache.org/licenses/LICENSE-2.0) license.
