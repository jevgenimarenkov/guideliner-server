# ![Optional Text](/src/main/resources/assets/guideliner.JPG)

Guideliner is an open source Web-based tool for automated evaluation of WUI conformance to usability guidelines. It concentrates on automatically evaluating of HTML-centric accessibility guidelines and guidelines covering visual characteristics of WUI. <a href="#ref-1">[1]</a> <a href="#ref-2">[2]</a> <a href="#ref-3">[3]</a>

The Guideliner has been established in cooperation between Tallinn University of Technology (TTÜ).

# Publications
If you find this application useful, please cite the following paper:

<a name="ref-1">[1] Marenkov, J., Robal, T., & Kalja, A.: Design-Time Web Usability Evaluation with Guideliner. Complex Systems Informatics and Modeling Quarterly, (15), 90-109. (2018)
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
<a name="ref-2">[2] Marenkov, J., Robal, T., Kalja, A.: Guideliner: A Tool to Improve Web UI Development for Better Usability. In: Proceedings of the 8th International Conference on Web Intelligence, Mining and Semantics (WIMS '18), Article 17, 9 pages. ACM, New York (2018) 
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
<a name="ref-3">[3] Marenkov, J., Robal, T., Kalja, A.: A Tool for Design-Time Usability Evaluation of Web User Interfaces. In: Proceedings of Advances in Databases and Information Systems, pp 394-407. Springer, Cham (2017)
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
# Features
  - Contains 55 accessibility guidelines, 23 common usability guidelines suitable for desktop and mobile devices and 20 usability guidelines suitable only for mobile devices
  - Provides REST API for automated usability evaluation
  - Guideliner can be used within a development IDE for automated usability evaluation during the implementation phase of WUI development
  - Allows writing usability unit tests
  - Contains usability ontology
  <p align="center">
    <a href="/src/main/resources/assets/usability_results.PNG"><img src="/src/main/resources/assets/usability_results.PNG" alt="IntelliEye Benchmark Tool in action" width="350" height="400"></a>
    <a href="/src/main/resources/assets/usability_guidelines.PNG"><img src="/src/main/resources/assets/usability_guidelines.PNG" alt="IntelliEye Benchmark Tool in action" width="350" height="400"></a>
 </p>
 
# Installing
Download the `.jar` file [here](/artifact/guideliner.jar). It includes all dependencies. You must have the [Java Runtime Environment](http://java.com/en/download/manual.jsp) version 8 and Mozilla Firefox installed.

# Usage
 - Execute command `java -jar guideliner.jar` in the downloaded directory. 
 - Redirect to http://localhost:8080/guidelines/index.html
  
# Development

Check out the code. Install and start the server.
```
$ mvn install
$ mnv spring-boot:run
```
# Remarks

This package is provided as is. Use at own risk.
