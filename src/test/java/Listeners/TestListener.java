package Listeners;

import Setup.BrowserFactory;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    ExtentTest test;
    WebDriver driver;
    public void onTestStart(ITestResult result)
    {
        test=SuiteListener.reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test "+result.getMethod().getMethodName()+" is passed");
    }
    public void onTestFailure(ITestResult result) {
        String screenshotDir = System.getProperty("user.dir") + "/Failurescreenshots" + result.getMethod().getMethodName() + System.currentTimeMillis();
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String screenshotPath = screenshotDir + System.currentTimeMillis() + ".png";
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("driver");
        if (driver != null) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            test.fail("Test Case Failed").addScreenCaptureFromPath(screenshotPath);
        }
    }
}
