# AutomationProject

✅ Key Components & Implementation
🧩 Framework Architecture
Built a modular, scalable, and maintainable framework following Page Object Model (POM) and BDD principles.

✅ Tools & Technologies Used
Java – Core programming language
Cucumber – For BDD-style feature definition
Selenium WebDriver – For browser automation
JUnit/TestNG – Test execution and lifecycle management
Maven – Build tool and dependency management
IntelliJ IDEA – IDE used for development

✅ Modules Implemented
Feature Files
Written in Gherkin syntax for clear and human-readable scenarios.
Separate .feature files created for each functionality under Telecom and Payment Gateway modules.

Step Definitions
Step binding layer that maps Gherkin steps to Java methods.
Reusable methods implemented to improve efficiency.

Page Object Classes
Encapsulated web elements and user actions for each page.
Promotes code reusability and reduces maintenance.

Driver Management
Supports browser parameterization and parallel execution (if needed).

Test Runner Class
Configured to execute scenarios using CucumberOptions (tags, plugin reporting, etc.).
Integrated with JUnit/TestNG as the test runner.

Maven Dependency Management
Managed all required libraries via pom.xml.

