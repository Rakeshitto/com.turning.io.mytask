package Objectrep;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Utilities implements ITestListener{
    static WebDriver driver;

    public void launchPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Title is " + driver.getTitle());
    }

    @Parameters({"username", "password"})
    public void performLogin(String username, String password) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"branding\"]/a[1]/img")));
        WebElement i = driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img"));
        Boolean p = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].complete "
                        + "&& typeof arguments[0].naturalWidth != \"undefined\" "
                        + "&& arguments[0].naturalWidth > 0", i);

        driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule > b")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu_recruitment_viewCandidates")));
        driver.findElement(By.cssSelector("#menu_recruitment_viewCandidates")).isDisplayed();

    }

    public void dateFormat() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        WebElement currentDate = driver.findElement(By.xpath("//input[@id='addCandidate_appliedDate']"));
        currentDate.clear();
        currentDate.sendKeys(dtf.format(localDate));

    }


//    public void readFileLoc() {
//        readFile("C:\\Users\\DELL\\Downloads\\DeravResume.txt");
//    }
//
//    public void readFile(String fileName) {
//
//        try (FileInputStream fis = new FileInputStream(new File(fileName))) {
//            int content;
//            // reads a byte at a time, if it reached end of the file, returns -1
//            while ((content = fis.read()) != -1) {
//                //System.out.println((char) content);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


//    public <ExtensionContext> void afterAll(ExtensionContext context) throws Exception {
//        Path content = Paths.get("C:/Downloads/DeravResume.txt");
//        try (InputStream is = Files.newInputStream(content)) {
//            Allure.addAttachment("Candidate's Resume", is);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}

