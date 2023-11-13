package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
public class ExtentManager {
    public RemoteWebDriver driver;
    public static ExtentReports extent;
    private ExtentTest test;
    private static ExtentSparkReporter htmlReporter;
    private static String reportDate;
    private static String filePath;


    /*TODO: Fix it to Relative & to checkl if its on the same project files*/
    private static String PATH_PREFIX = "C:\\Users\\Shadi Ibrahim\\IdeaProjects\\CampusILTesting\\src\\test\\reports";



    static {
        reportDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
                .format(Calendar.getInstance().getTime());
        filePath = PATH_PREFIX + "\\" + reportDate + "\\exReport.html";
    }

    public ExtentManager(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ExtentReports GetExtent() {
        new File(PATH_PREFIX + "\\" + reportDate).mkdirs();
        if (extent != null)
            return extent; //avoid creating new instance of html file
        extent = new ExtentReports();
        extent.attachReporter(getHtmlReporter());
        return extent;
    }

    public ExtentTest createTest(String name, String description) {
        if (test == null) {
            test = extent.createTest(name, description);
        }
        return test;
    }

    private static ExtentSparkReporter getHtmlReporter() {
        htmlReporter = new ExtentSparkReporter(filePath);
        htmlReporter.config().setDocumentTitle("QAV automation report");
        htmlReporter.config().setReportName("Regression cycle");
        //TODO: test if relevant
        //htmlReporter.config().setEncoding("UTF-8");
        return htmlReporter;
    }

    public static String CaptureScreen(WebDriver driver) throws AWTException, IOException {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("ddHHmmss"));
        String folderPath = (PATH_PREFIX + "\\" + reportDate);
        String imagePath = folderPath + "/pic" + time + ".jpg";
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(imagePath);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile, oDest);
        return imagePath;
    }
}
