# ![Optional Text](/src/main/resources/assets/guideliner.JPG)

Guideliner is an open source tool for automated evaluation of WUI conformance to usability guidelines.

# Installing
Download the `.jar` file [here](/artifact/guideliner.jar). It includes all dependencies. You must have the [Java Runtime Environment](http://java.com/en/download/manual.jsp) version 8 and Mozilla Firefox installed.

# Usage
 - Execute command `java -jar guideliner.jar` in the downloaded directory. 
 - Redirect to http://localhost:8080/guidelines/index.html

# Features

  - Allows writing usability unit tests
  - Contains more than 100 predefined usability tests for mobile and desktop applications
  - Provides REST API for usability evaluation
  
# Development

Check out the code. Install and start the server.
```
$ mvn install
$ mnv spring-boot:run
```
