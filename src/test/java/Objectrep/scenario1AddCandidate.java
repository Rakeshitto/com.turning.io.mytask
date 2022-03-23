package Objectrep;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class scenario1AddCandidate extends Utilities{


@BeforeTest
@Parameters({"username", "password"})
    public void beforeTest(String username, String password) throws Throwable {
    scenario1AddCandidate obj = new scenario1AddCandidate();
        obj.launchPage();
        obj.performLogin(username, password);
    }


@Parameters({"firstname", "lastname", "email", "contactno", "cvpath"})
@Test (priority = 1, description = "This test is to add a new candidate")
@Description("Test Description: This test is to add a new candidate")
    public void addCandidate(String firstname, String lastname, String email, String contactno, String cvpath) throws Throwable{
        scenario1AddCandidate obj = new scenario1AddCandidate();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));
        driver.findElement(By.id("btnAdd")).click();
        WebElement formHeading = driver.findElement(By.id("addCandidateHeading"));
        formHeading.getText();
        Assert.assertTrue(String.valueOf(formHeading), true);
        driver.findElement(By.cssSelector("#addCandidate_firstName")).sendKeys(firstname);
        driver.findElement(By.cssSelector("#addCandidate_lastName")).sendKeys(lastname);
        driver.findElement(By.cssSelector("#addCandidate_email")).sendKeys(email);
        driver.findElement(By.cssSelector("#addCandidate_contactNo")).sendKeys(contactno);
        Select selctJob = new Select(driver.findElement(By.cssSelector("#addCandidate_vacancy")));
        selctJob.selectByValue("6");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#addCandidate_resume")));
        WebElement addResumeBtn = driver.findElement(By.cssSelector("#addCandidate_resume"));
        addResumeBtn.sendKeys(cvpath);
       WebElement keywords = driver.findElement(By.cssSelector("#addCandidate_keyWords"));
       keywords.sendKeys("this is a test");
       WebElement comments = driver.findElement(By.cssSelector("#addCandidate_comment"));
       comments.sendKeys("this is a test comment");
//        WebElement date = driver.findElement(By.xpath("//input[@id='addCandidate_appliedDate']"));
//        obj.dateFormat();

        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Assert.assertTrue("Successfully saved", true);
        System.out.println("Candidate is added Successfully");

    }

    @Test (priority = 2)
    public void logout(){
    driver.close();
    driver.quit();
    }
}
