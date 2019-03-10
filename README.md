# ![Optional Text](/src/main/resources/assets/guideliner.JPG)

Guideliner is an open source tool for automated evaluation of WUI conformance to usability guidelines. It concentrates on automatically evaluating of HTML-centric accessibility guidelines and guidelines covering visual characteristics of WUI. The main contributions of the Guideliner are the method for evaluation of visual usability guidelines of rendered WUI, and second a tool to carry out automatic evaluation of WUI and its accordance to guidelines, including automated visual evaluation.

# Installing
Download the `.jar` file [here](/artifact/guideliner.jar). It includes all dependencies. You must have the [Java Runtime Environment](http://java.com/en/download/manual.jsp) version 8 and Mozilla Firefox installed.

# Usage
 - Execute command `java -jar guideliner.jar` in the downloaded directory. 
 - Redirect to http://localhost:8080/guidelines/index.html

# Features

  - Allows writing usability unit tests
  - Contains 98 predefined usability tests for mobile and desktop applications
  - Provides REST API for usability evaluation
  
# Development

Check out the code. Install and start the server.
```
$ mvn install
$ mnv spring-boot:run
```
