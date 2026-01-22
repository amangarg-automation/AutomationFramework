package Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    // ThreadLocal ensures each thread gets its own instance of WebDriver
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to initialize the WebDriver for different browsers
    public static WebDriver getBrowser(String browserName) {
        // If the driver is not set yet, initialize it based on the browser name
        if (driver.get() == null) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    // Uncomment WebDriverManager if you want automatic management of driver versions
                    // WebDriverManager.chromedriver().setup();
                   // System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); // Set your path
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--headless");
                    driver.set(new ChromeDriver(chromeOptions));  // Store the ChromeDriver instance in ThreadLocal
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();  // Automatically manage EdgeDriver
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--incognito");
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--disable-notifications");
                    edgeOptions.addArguments("--start-maximized");
                    driver.set(new EdgeDriver(edgeOptions));  // Store the EdgeDriver instance in ThreadLocal
                    break;

                case "firefox":
                  //Automatically manage FirefoxDriver
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private");
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--disable-notifications");
                    driver.set(new FirefoxDriver(firefoxOptions));
                    driver.get().manage().window().maximize();// Store the FirefoxDriver instance in ThreadLocal
                    break;

                default:
                    throw new RuntimeException("No such Browser available: " + browserName);
            }
        }
        return driver.get();  // Return the existing WebDriver instance
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
    // Method to close the WebDriver instance
    public static void closeBrowser() {
        if (driver.get() != null) {
            driver.get().quit();  // Quit the driver
            driver.remove();  // Remove the WebDriver instance from the current thread
        }
    }
}
