Hurray
======
Huuray is the web application automation framework developed using Selenium web driver (JAVA).
* By using Hurray we can run the developed automation tests either in Linear or Parallel execution modes 
* 'diwng.xml' and diw-grid.xml' are TestNG related files by using diwng.xml we can the tests in linear mode and diw-grid.xml needs to be used to run tests in Parallel mode.

How to run:
===========
[Maven]: http://maven.apache.org/
To run the project,install [Maven].
Use the following maven command to run the tests linearly: 
* Mvn clean test

To run the test in Parallel mode open the POM.xml find the following text :"${basedir}\diwng.xml" and change it to "${basedir}\diw-grid.xml"
after that use following maven command to run the tests parallel:
* Mvn clean test
[Allure]:http://allure.qatools.ru/
[ReportNG]:http://reportng.uncommons.org/
[Hub and node setup]:https://code.google.com/p/selenium/wiki/Grid2

Note: To run the test in parallel execution we need to setup Hub and nodes externally see [Hub and node setup]
Reports:
========
In Hurray [Allure] framework and [ReportNG] is used for test results reports.
To view the ReportNg generated results open the index.html file at the following location:\target\surefire-reports\html

To view the Allure generated results you should perform following steps:
* Mvn clean test
* Mvn site

After that open allure-maven-plugin.html  in the  following location \site\allure-maven-plugin.html

Note: When opening allure-maven-plugin.html from the local file either open it in Firefox or launch Chrome with --allow-file-access-from-files flag. For other browsers you need to enable cross origin requests to local files.

Browsers on which Hurray will run:
==================================
Right now Hurray can be run in  Chrome,IE,and firefox
In order to run the test on above browsers open  diwng.xml(for linear mode) find the following text: "parameter name="browser" value="XXX" 
'XXX' values are 
================
* 'org.openqa.selenium.firefox.FirefoxDriver'
* 'org.openqa.selenium.chrome.ChromeDriver'
* 'org.openqa.selenium.ie.InternetExplorerDriver'

Depend on the requirement put any one of the above values in place of XXX.
Using Hurray for your projects:
================


 




