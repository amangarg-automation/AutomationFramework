package Setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ISuite;
import org.testng.ITestContext;

public class ExtentManager {
    private static ExtentReports reports;
    private static ExtentSparkReporter reporter;
    public static ExtentReports getInstance(ISuite suite)
    {
        String reportsPath=System.getProperty("user.dir")+"/ExtentReports/"+suite.getName();
        reporter=new ExtentSparkReporter(reportsPath);
        reports=new ExtentReports();
        reports.attachReporter(reporter);
        reports.setSystemInfo("Environment","QA");
        return reports;
    }
}
