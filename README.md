Hurray
======
Huuray is the web application automation framework developed using Selenium web driver(JAVA).

By using Hurray we can run the develpoed automation tests either in Linear or Parallel execution modes 

'diwng.xml' and diw-grid.xml' are TestNg realted files by using diwng.xml we can the tests in linera mode and diw-grid.xml needs to be used inorder to run tests in Parllel mode.

How to run:
===========
[Maven]: http://maven.apache.org/
To run the project you need to install [Maven].
use the following maven command to run the tests lineraly: 
* mvn clean test
To run the test in Parallel mode open the POM.xml find the following tag :<suiteXmlFile>${basedir}\diwng.xml</suiteXmlFile> and change it to <suiteXmlFile>${basedir}\diwng.xml</suiteXmlFile>
After that use following maven commands to run the tests parllely:
* mvn clean test
[Allure]:http://allure.qatools.ru/
[ReportNG]:http://reportng.uncommons.org/
[Hub and node setup]:https://code.google.com/p/selenium/wiki/Grid2

Note: To run the test in parallel execution we need to setup Hub and nodes and externally see [Hub and node setup]

Reports:
========
In Hurray [Allure] framework and [ReportNG] is used for test results.

To view the ReportNg generated results open the index.html file at the following location:\target\surefire-reports\html

To view the Allure generated results you should perform following steps:
* mvn clean test
* mvn site

After that Open allure-maven-plugin.html  in the  following location \site\allure-maven-plugin.html
Note: When opening allure-maven-plugin.html from the local file either open it in Firefox or launch Chrome with --allow-file-access-from-files flag. For other browsers you need to enable cross origin requests to local files.


Browsers on which Hurray will run:
==================================
Righ now Hurray can be run in  Chrome,IE,and firefox

inorder to run the test on above browsers open  diwng.xml(for linear mode) find the the <parameter name="browser" value="XXX"> tag
'XXX' values are 
================
* 'org.openqa.selenium.firefox.FirefoxDriver'
* 'org.openqa.selenium.chrome.ChromeDriver'
* 'org.openqa.selenium.ie.InternetExplorerDriver'
* 
depend on the requiremnt use an y on of the the above values



Using Hurray for your projects:
================


 




