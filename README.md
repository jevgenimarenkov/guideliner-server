# Guideliner

Guideliner is a tool for automatic usability evaluation.

# Features

  - Allows writing usability unit tests
  - Contains more than 100 predefined usability tests for mobile and desktop applications
  - Provides REST API for usability evaluation

### Running as standalone server 

Guideliner requires [JDK 1.8 +] to run.

Install and start the server.

```sh
$ mvn install
$ java -jar guideliner-server.jar
```
### Running as unittest

```sh
mvn test -Durl=https://www.example.com
```

-Durl parameter can contain any URL that you would like to verify
