package Listeners;

import Setup.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;

public class SuiteListener implements ISuiteListener {
    public static ExtentReports reports;
    public void onStart(ISuite suite)
    {
        reports= ExtentManager.getInstance(suite);

    }
    public void onFinish(ISuite suite)
    {
        reports.flush();
    }
}
