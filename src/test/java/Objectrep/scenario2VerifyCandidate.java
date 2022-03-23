package Objectrep;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners({ Utilities.class })

public class scenario2VerifyCandidate extends Utilities{

@Test (priority = 3)
@Parameters({"username", "password"})
    public void beforeTest(String username, String password) throws Throwable {
     scenario2VerifyCandidate obj = new scenario2VerifyCandidate();
        obj.launchPage();
        obj.performLogin(username, password);
    }

@Parameters({"firstname", "lastname"})
@Test (priority = 4, description = "This test is to verify added candidate")
@Description("Test Description: This test is to verify added candidate")
    public void verifyCandidate(String firstname, String lastname) throws Throwable{
        scenario2VerifyCandidate obj = new scenario2VerifyCandidate();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='candidateSearch_candidateName']")));
        String fn = firstname;
        String fullname = fn.concat(" "+lastname);
        driver.findElement(By.xpath("//input[@id='candidateSearch_candidateName']")).sendKeys(fullname);
        driver.findElement(By.xpath("//input[@id='btnSrch']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#resultTable > tbody > tr.odd > td:nth-child(3) > a")));
        WebElement candidateAfterSearch = driver.findElement(By.cssSelector("#resultTable > tbody > tr.odd > td:nth-child(3) > a"));
        Assert.assertEquals(candidateAfterSearch.getText(), fullname);
        System.out.println(fullname);
        if (candidateAfterSearch.getText().equals(fullname) ){
            driver.findElement(By.cssSelector("#resultTable > tbody > tr.odd > td:nth-child(7) > a")).click();
            System.out.println("Candidate's resume is downloaded");
            Thread.sleep(1000);

        }
            else{
                System.out.println("Candidate does not exist");
        }


    }


 @AfterTest
    public void logout(){
        driver.close();
        driver.quit();
        System.out.println("Test is completed");
    }
}
