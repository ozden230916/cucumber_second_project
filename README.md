I use Maven as a build toll.My dependencies that are stored in pom.xml file are
Selenium-java, Web driver manager, html unit driver, cucumber-java, cucumber-junit.
I use java programming language.I create feature files under the features folder in resources.
In feature file, I used feature keyword to define the functionality, and I used Gherkin language to
define test scenario, test steps and expected results.
I created Pages to use page object model, Steps class to implement the Gherkin steps in feature file,Runner class
to link the feature file with Step class, and run the scenario.
I defined Smoke and Regression tags in feature file. I integrated pom.xml with Runner class by using surefire plugin.
It allows me to run different suites with maven command and get reports.

