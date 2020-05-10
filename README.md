# Dropwizard usage example

It includes:
* An HTTP API implemented using [DropWizard](https://www.dropwizard.io/en/latest/)
* Example of a JSON model used by a resource of the API
* A very simple web application using this API
* The use of main [DropWizard](https://www.dropwizard.io/en/latest/) features like the use of the configuration file, logging, health-check, banner, ...
* A packaging that delivers ready-to-run binary for Windows and Unix based operating systems (with embedded dependencies and start scripts)
* A split of the code into meaningfull maven modules

## How to see it working

### Dependencies and build

First, you need to build the project. Make sure you have the following installed:

* A *Java Runtime Environment* version 8+ for the API.
* [Apache Maven](https://maven.apache.org/) version 3.0 or more
* An *evergreen* web browser (not IE)

Then, run

    mvn install

At last, a new `target` sub-directory should appear in the project directory. It contains everything needed by the demo.

### Usage

1. Go to the `target` sub-directory
2. Execute either `start.sh` from Linux or MacOS, or `start.bat` from Windows.
3. Logs should flow towards the standard output and a web page will appear soon.
4. If a web page is not opened automatically or if this page shows an error, you can try to go to the URL file://target/index.html#8000 (with the hash) since 8000 is the default port used. An automatic redirect towards this URL is currently done in the web-page when it detects a failure. (this issue has been seen only from Windows, as the hash of the URL that is opened after the start of the API is missing). At the end, you should see a web page displaying some values provided by the API.
5. Hit `Ctrl+C` from the console (or close the terminal window) in order to stop the Java application implementing the API.

## Implementation details

Instead of using a provided start script, you can also run the server with the following command:

    java -jar target/app.jar server target/configuration.yml

This server will deploy an API accessible from [http://localhost:8000/api](http://localhost:8000/api) by default.

The API port can be configured as the attribute `server.connecter.port` in the configuration file.

## License

This project is using the [Apache2](https://www.apache.org/licenses/LICENSE-2.0) license.
