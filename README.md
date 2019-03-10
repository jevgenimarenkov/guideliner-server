# ![Optional Text](/src/main/resources/assets/guideliner.JPG)

Guideliner is an open source tool for automated evaluation of WUI conformance to usability guidelines. It concentrates on automatically evaluating of HTML-centric accessibility guidelines and guidelines covering visual characteristics of WUI. The main contributions of the Guideliner are the method for evaluation of visual usability guidelines of rendered WUI, and second a tool to carry out automatic evaluation of WUI and its accordance to guidelines, including automated visual evaluation.

# Publications
[1] Marenkov, J., Robal, T., & Kalja, A.: Design-Time Web Usability Evaluation with Guideliner. Complex Systems Informatics and Modeling Quarterly, (15), 90-109. (2018)
```
@article{marenkov2018design,
  title={Design-Time Web Usability Evaluation with Guideliner},
  author={Marenkov, Jevgeni and Robal, Tarmo and Kalja, Ahto},
  journal={Complex Systems Informatics and Modeling Quarterly},
  number={15},
  pages={90--109},
  year={2018}
}
```
[2] Marenkov, J., Robal, T., Kalja, A.: Guideliner: A Tool to Improve Web UI Development for Better Usability. In: Proceedings of the 8th International Conference on Web Intelligence, Mining and Semantics (WIMS '18), Article 17, 9 pages. ACM, New York (2018) 
```
@inproceedings{marenkov2018guideliner,
  title={Guideliner: a Tool to Improve Web UI Development for Better Usability},
  author={Marenkov, Jevgeni and Robal, Tarmo and Kalja, Ahto},
  booktitle={Proceedings of the 8th International Conference on Web Intelligence, Mining and Semantics},
  pages={17},
  year={2018},
  organization={ACM}
}
```
[3] Marenkov, J., Robal, T., Kalja, A.: A Tool for Design-Time Usability Evaluation of Web User Interfaces. In: Proceedings of Advances in Databases and Information Systems, pp 394-407. Springer, Cham (2017)
```
@inproceedings{marenkov2017tool,
  title={A Tool for Design-Time Usability Evaluation of Web User Interfaces},
  author={Marenkov, Jevgeni and Robal, Tarmo and Kalja, Ahto},
  booktitle={European Conference on Advances in Databases and Information Systems},
  pages={394--407},
  year={2017},
  organization={Springer}
}
```
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
