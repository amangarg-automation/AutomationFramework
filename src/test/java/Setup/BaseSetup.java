package Setup;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseSetup {
    public WebDriver driver;
    Properties prop;
    @BeforeTest
    public void setupTest( ) throws IOException {
         prop=new Properties();
        FileInputStream fis=new FileInputStream("config.properties");
        prop.load(fis);
    }

    @BeforeMethod
    @Parameters("browser")
    public void startBrowser(ITestContext context, String browser)
    {
        driver=BrowserFactory.getBrowser(browser);
        driver.get(prop.getProperty("url"));
        context.setAttribute("driver",driver);
    }
    @AfterMethod
    public void closeBrowser()
    {
        BrowserFactory.closeBrowser();
    }

}
