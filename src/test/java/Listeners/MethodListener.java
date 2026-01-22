package Listeners;

import Setup.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.Properties;

public class MethodListener implements IInvokedMethodListener {
    /**
    public WebDriver driver; // WebDriver instance for the test execution
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        if (method.isTestMethod() && driver == null) { // Only initialize if WebDriver is not already set
            driver = BrowserFactory.getBrowser(ExecutionListener.browser);
            System.out.println(ExecutionListener.url);// Get WebDriver instance based on browser name
            driver.get(ExecutionListener.url);
            result.setAttribute("driver", driver);// Navigate to the URL specified in properties
        }
    }
**/
}
