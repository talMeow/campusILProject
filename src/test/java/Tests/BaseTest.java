package Tests;

import Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public abstract class BaseTest {
    RemoteWebDriver driver;
    ExtentTest test;
    ExtentManager exm;

    /**
     * to be used in beforeTest method only!
     **/
    void intitializeExtent() {
        if (driver == null) {
            throw new RuntimeException("driver must be initialized!");
        }
        exm = new ExtentManager(this.driver);
    }

    void markStepPass(String message) throws IOException, AWTException {
        if (test == null) {
            return;
        }
        test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
    }

    void markStepFail(String message) throws IOException, AWTException {
        if (test == null) {
            return;
        }
        test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
    }
    @Parameters("BROWSER")
    @BeforeTest
    public void build(String BROWSER) throws IOException, ParserConfigurationException, SAXException {
        switch (BROWSER) {
            case "chrome":
                this.driver = new ChromeDriver();
                break;
            case "edge":
                this.driver = new EdgeDriver();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        intitializeExtent();
        exm.GetExtent();
        test = exm.createTest("name", "description");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (exm != null) {
            exm.GetExtent().flush();
        }
    }
}
