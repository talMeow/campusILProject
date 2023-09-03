package Tests;

import PageObjects.DashboardsPage;
import PageObjects.MainSite;
import PageObjects.SignInForm;
import Resources.XML_JAVA_LOGIN;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;
public class SignIn extends BaseTest {
    private static String DASHBOARD_LINK = "https://courses.campus.gov.il/dashboard";

    @DataProvider(name = "getData")//DATA PROVIDER EXAMPLE
    public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
        Object[][] data = XML_JAVA_LOGIN.XML_JAVA_LOGIN();
        return data;
    }
    @Test(dataProvider = "getData")
    // to pass data from data provider to the test ** important to add variables in the function STAMP
    public void goToSignIn(String username, String password, String status) throws IOException, AWTException, InterruptedException, ParserConfigurationException, SAXException {
        try {
            MainSite main_site = new MainSite("https://campus.gov.il", this.driver);
            DashboardsPage dash = new DashboardsPage("https://campus.gov.il", this.driver);
            markStepPass("page opened!");
            SignInForm registration_page = main_site.clickOnSignInAndGoToSignInPage();
            markStepPass("page opened!");
            registration_page.set_user_name(username);
            markStepPass("page opened!");
            registration_page.set_password(password);
            markStepPass("page opened!");
            registration_page.click_on_sign_in_and_go_to_dashboards_page();
            markStepPass("page opened!");
            new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(DASHBOARD_LINK));
            markStepPass("page opened!");
            Assert.assertEquals(driver.getCurrentUrl(), DASHBOARD_LINK);
            dash.dashboard_SignOut();
        } catch (Exception e) {
            if (status.equals("invalid")) {
                markStepPass("pass");
            } else {
                markStepFail("fail");
            }
        }
    }
}
