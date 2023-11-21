package Tests;

import PageObjects.MainSite;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class ControllersTest extends BaseTest{
    @Test
    public void controllersTest() throws IOException, AWTException {
        MainSite main_site = new MainSite("https://campus.gov.il", this.driver);
        for (int i=0;i<main_site.navigate_buttons.size();i++) {
            main_site.navigate_buttons.get(i).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            if(driver.getTitle().contains("Page not found")){
                markStepFail("Fail");
            }else {markStepPass("step pass");}
        }
    }
}
