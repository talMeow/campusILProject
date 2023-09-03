package Tests;

import PageObjects.MainSite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;
public class SignOut extends BaseTest{
    @Test
    public void SignOutTest() throws IOException, AWTException {
        try {
            MainSite main_site = new MainSite("https://campus.gov.il", this.driver);
            main_site.mainSite_SignOut();
            markStepPass("Signed Out");
        }catch(Exception e){
            markStepFail("Fail");
        }
    }
}
