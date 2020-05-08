# ETC Table Pairing Tool

Helps at pairing armies on tables using rules of the **European Tabletop Championship**.

## Dependnencies

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

    java -jar target/table-pairing.jar server target/configuration.yml

This server will deploy an API accessible from [http://localhost:8000/api](http://localhost:8000/api) by default. The API port can be configured as the attribute `server.connecter.port` in the configuration file.

## License

This project is licensed according to **CC BY-NC-SA** ( [description](https://creativecommons.org/licenses/by-nc-sa/4.0/) | [legal](https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode) )

