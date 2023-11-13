package Tests;

import PageObjects.DashboardsPage;
import PageObjects.MainSite;
import PageObjects.SignInForm;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;
public class SignOut extends BaseTest {
    private static String DASHBOARD_LINK = "https://courses.campus.gov.il/dashboard";

    @Test
    public void SignOutTest() throws IOException, AWTException, InterruptedException {

        MainSite main_site = new MainSite("https://campus.gov.il", this.driver);
        DashboardsPage dash = new DashboardsPage("https://campus.gov.il", this.driver);
        SignInForm registration_page = main_site.clickOnSignInAndGoToSignInPage();
        registration_page.set_user_name("shadi.ibr7@gmail.com");
        registration_page.set_password("i123so123");
        registration_page.click_on_sign_in_and_go_to_dashboards_page();
        new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(DASHBOARD_LINK));
        Assert.assertEquals(driver.getCurrentUrl(), DASHBOARD_LINK);
        try {
            dash.dashboard_SignOut();
            markStepPass("Signed Out");
        } catch (Exception e) {
            markStepFail("Fail");
        }
    }
}



