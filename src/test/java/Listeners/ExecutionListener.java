package Listeners;

import org.testng.IExecutionListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExecutionListener implements IExecutionListener
{
    public static String url;
    public static String browser;
    public void onExecutionStart()
    {
        Properties prop=new Properties();
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
            url=prop.getProperty("url");
            browser= prop.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
