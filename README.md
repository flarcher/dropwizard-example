# Dropwizard API example

It includes:
* An HTTP API implemented using [DropWizard](https://www.dropwizard.io/en/latest/)
* A very simple web application using this API

## Dependencies

* It needs a *Java Runtime Environment* version 8+ for the API.
* An *evergreen / modern* web browser (not IE)

## Usage

Calls either `start.sh` from Linux or MacOS, or `start.bat` from Windows.

## Contributing

In order to build the project, you will need:
* A *JDK* version 8+
* [Apache Maven](https://maven.apache.org/)

Here is the command for the build:

    maven install

Then, you can run the server with:

    java -jar target/app.jar server target/configuration.yml

This server will deploy an API accessible from [http://localhost:8000/api](http://localhost:8000/api) by default. The API port can be configured as the attribute `server.connecter.port` in the configuration file.

## License

This project is using the [Apache2](https://www.apache.org/licenses/LICENSE-2.0) license.

