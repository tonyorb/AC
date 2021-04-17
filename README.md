# AC
Project contains test documentation, API test framework and implemented set of tests for Ataccama TestCalc application.

Tools:
- Rest Assured
- Maven
- JUnit5
- Allure

Requirements:
- Java 14 or above
- Maven 3.6.3 or above

Get started:
1. Deploy qa_testCalc_java11 application
2. Clone project from github
3. Open terminal and go to AC/api/ directory
4. Run "mvn clean test allure:serve" command
5. Allure report will be automatically opened in your browser

Configure:
- You can find configure file in "src/main/resources/config.properties"
- You can run "mvn clean test -DbaseUrl={your_url} -Dport={your_port} -DbasePath={your_base_path} allure:serve"

Test documentation is in AC/testdocs/ directory:
- Summary of testing
- Test scripts examples
- An example of a bug report