# ![Optional Text](/src/main/resources/assets/guideliner.JPG)
Guideliner is an open source Web-based tool for automated evaluation of Web User Interface (WUI) conformance to usability guidelines. It concentrates on automatically evaluating HTML-centric accessibility guidelines and guidelines covering visual characteristics of WUI. 

Guideliner provides a possibility to perform pre-release and implementation-time usability testing of Web user interfaces verifying that all developed features are compliant with the set usability guidelines, defined in the usability ontology  <a href="#ref-1">[1]</a>  <a href="#ref-4">[4]</a>. In general, Guideliner helps to increase the overall quality of WUIs as it performs the evaluation of WUI conformance to HTML-specific usability guidelines as well as enables to check the WUI conformance to guidelines addressing the visual characteristics of WUIs. The latter is a novelty delivered by Guideliner. Applicability of the Guideliner does not stick to any particular WUI development process (e.g., agile or waterfall) but rather is a universal tool challenging a problem of immediate usability evaluation, especially during WUI development and implementation phases <a href="#ref-1">[1]</a> <a href="#ref-2">[2]</a> <a href="#ref-3">[3]</a> <a href="#ref-4">[4]</a>.



The Guideliner has been established as an outcome of research conducted in Tallinn University of Technology (TTÜ).

# Publications
If you find this application useful, please cite the following papers:

<a name="ref-1">[1] Marenkov, J., Robal, T., & Kalja, A.: Design-Time Web Usability Evaluation with Guideliner. Complex Systems Informatics and Modeling Quarterly, (15), 90-109. (2018)
```
@article{marenkov2018design,
  title={Design-Time Web Usability Evaluation with Guideliner},
  author={Marenkov, Jevgeni and Robal, Tarmo and Kalja, Ahto},
  journal={Complex Systems Informatics and Modeling Quarterly},
  number={15},
  pages={90--109},
  month = {jul},
  year={2018},
  doi = {10.7250/csimq.2018-15.05},
  url = {https://doi.org/10.7250/csimq.2018-15.05}
}
```
<a name="ref-2">[2] Marenkov, J., Robal, T., Kalja, A.: Guideliner: A Tool to Improve Web UI Development for Better Usability. In: Proceedings of the 8th International Conference on Web Intelligence, Mining and Semantics (WIMS '18), Article 17, 9 pages. ACM, New York (2018) 
```
@inproceedings{marenkov2018guideliner,
 author = {Marenkov, Jevgeni and Robal, Tarmo and Kalja, Ahto},
 title = {Guideliner: A Tool to Improve Web UI Development for Better Usability},
 booktitle = {Proceedings of the 8th International Conference on Web Intelligence, Mining and Semantics},
 series = {WIMS '18},
 year = {2018},
 isbn = {978-1-4503-5489-9},
 location = {Novi Sad, Serbia},
 pages = {17:1--17:9},
 articleno = {17},
 numpages = {9},
 url = {http://doi.acm.org/10.1145/3227609.3227667},
 doi = {10.1145/3227609.3227667},
 acmid = {3227667},
 publisher = {ACM},
 address = {New York, NY, USA},
 keywords = {Web usability evaluation, usability guidelines, web user interface},
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
  organization={Springer},
  publisher = {Springer International Publishing},
  doi = {10.1007/978-3-319-66917-5_26},
  url = {https://doi.org/10.1007/978-3-319-66917-5_26}
}
```
<a name="ref-4">[4] Robal, T., Marenkov, J. & Kalja, A.: Ontology design for automatic evaluation of web user interface usability. PICMET ‘17: Proceedings, Technology Managemen for Interconnected World: July 9 - 13, 2017, Portland, Oregon, USA. Editors: Kocaoglu, PICMET, USA (2017)
```
@inproceedings{Robal2017,
  title = {Ontology Design for Automatic Evaluation of Web User Interface Usability},
  author = {Robal, Tarmo and Marenkov, Jevgeni and Kalja, Ahto},
  pages={1-8}, 
  year  = {2017},
  month = {jul},
  publisher = {{IEEE}},
  booktitle = {2017 Portland International Conference on Management of Engineering and Technology ({PICMET})},
  doi = {10.23919/picmet.2017.8125425},
  url = {https://doi.org/10.23919/picmet.2017.8125425},
  keywords={human computer interaction; ontologies (artificial intelligence); user interfaces; ontology design; web user interface automatic evaluation; web usability; UI evaluation; Usability; Guidelines;}, 
}
```
# Features
  - Contains 55 accessibility guidelines, 23 common usability guidelines suitable for desktop and mobile devices and 20 usability guidelines suitable only for mobile devices.  The primay sources of guidelines are recommendations in scientific publications, WCAG and Section 508 guidelines, Research-Based Web Design and Usability Guidelines from U.S. Dept. of Health and Human Services, and supplemented with recommendations from the Nielsen Norman Group. All guidelines are stored in designed usability ontology.
  - Allows checking WUI conformance to visual usability as well as HTML-centric usability guidelines.
  - Provides REST API for automated usability evaluation. REST API contins operations for retrieving defined usabiltiy guidelines and triggering the evaluation process.
  - Guideliner can be used within a development IDE (e.g. Eclipse, IntelliJ IDEA) for automated usability evaluation during the implementation phase of WUI development.
  - Allows triggering automated usability tests as unit tests.

|||
| :---: |:---:|
| ![Screenshot2](/src/main/resources/assets/usability_guidelines.PNG) |
| ![Screenshot1](/src/main/resources/assets/usability_results.PNG)    |
| Screenshot of the Guideliner User Interface – an excerpt contains initial page for triggering the evaluation process |
| Screenshot from the Guideliner User Interface – an excerpt contains an example of a passed and a failed usability evaluation result. 


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
