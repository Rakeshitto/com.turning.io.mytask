# com.turning.io.mytask
**Project Type**: Maven
**Programming language**: Java (JDK 17 used)
**Testing Framework**: TestNG
**Reporting tool**: Allure Reports
**IDE used**: IntelliJ
**Test details**
    No of Test scenarios: 2
    No of test cases: 6 including @BeforeTest and @AfterTest
 
This project allows you to run test scenarios which are present under src/test/java. Below are the instructions of how to run this project on your local

- Clone this project to your local by git clone https://github.com/Rakeshitto/com.turning.io.mytask.git
- Open the project using an IDE (IntelliJ preferably)
- Before running the project make sure you have already set up allure reports on your machine. If not so, follow instructions on        
  https://docs.qameta.io/allure/#_get_started
- Make sure project does not show any compilation errors. Since this is a Maven project, make sure you have maven installed on your machine and also set your 
  path(Environment variables)
- The browser is set to 'headless'. To make the browser visible, change the below code under Utilities.launchPage()
     Existing:  <ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);>

       Update:  <driver = new ChromeDriver();>
  
- Open a terminal (in case of IntelliJ, IDE itself has a terminal)
- Change the directory to the project path
- Run the command >mvn clean test
- The project has ability to read parameters from command line. To do so, you need to enter parameters as below
   ** >mvn clean test -Dusername=<username> -Dpassword=<password> -Dcvpath=<path\\cv.pdf>**
- Once the tests are executed successfully, go to the terminal and enter the command >allure scope <path of target\allure-results>
- Results will be shown in a Temp file on a browser
- Allure Report will show results on multiple metrics like Overview, Suites, Graphs, etc.


  
