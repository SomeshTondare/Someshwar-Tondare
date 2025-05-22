package test;

import org.openqa.selenium.WebDriver;
import java.lang.reflect.Method;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportManager;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }
    
    @BeforeMethod
    public void setup(Method method) {
        System.out.println("Launching Chrome...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println("Navigated to Swag Labs.");
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
