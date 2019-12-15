# ETC Table Pairing Tool

Helps at pairing armies on tables using rules of the **European Tabletop Championship**.

## Usage

It needs a *Java Runtime Environment* version 8+ for a run.

The package is a *fat JAR* file, and here is an example of use:

    java -jar <JAR_file> server <configuration_file>

## Contributing

In order to build the project, you will need:
* A *JDK* version 8+
* [Apache Maven](https://maven.apache.org/)

Here is the command for the build:

    maven install

With the source code, we can run the server with:

    java -jar http-api/target/http-api-1.0-SNAPSHOT.jar server configuration.yml
   
## License

This project is licensed according to **CC BY-NC-SA** ( [description](https://creativecommons.org/licenses/by-nc-sa/4.0/) | [legal](https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode) )

