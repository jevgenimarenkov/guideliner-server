# Guideliner

Guideliner is a tool for automatic usability evaluation.

# Installing
Download the `.jar` file [here](/artifact/guideliner.jar). It includes all dependencies. You must have the [Java Runtime Environment](http://java.com/en/download/manual.jsp) version 8 and Mozilla Firefox installed.

![Optional Text](/src/main/resources/assets)

# Usage
 - Execute command `java -jar guideliner.jar` in the downloaded directory. 
 - Redirect to http://localhost:8080/guidelines/index.html

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
