package TestCases;

import Listeners.ExecutionListener;
import Setup.BaseSetup;
import Setup.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListener;
import Listeners.SuiteListener;
import Listeners.MethodListener;

import java.time.Duration;

@Listeners({ExecutionListener.class, MethodListener.class, SuiteListener.class, TestListener.class})
public class TC01 extends BaseSetup {
    @Test
    public void loginTest()
    {
        boolean flag=true;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("nav-link-accountList"))));
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email_login")).sendKeys("amankg266@gmail.com");
        driver.findElement(By.xpath("//input[contains(@class,'a-button-input')]")).click();
        driver.findElement(By.id("ap_password")).sendKeys("amangargkg");
        driver.findElement(By.id("signInSubmit")).click();
        if(driver.findElement(By.xpath("//div[contains(@class,'a-alert-content')]")).isDisplayed())
        {
            flag=true;
        }
        else {
            flag=false;
        }
        Assert.assertTrue(flag);
    }
}
