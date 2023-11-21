package Tests;

import PageObjects.MainSite;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class SearchTest extends BaseTest {
    @Parameters("TEXT_TO_SEARCH")
    @Test
    public void searchTest(String TEXT_TO_SEARCH) throws IOException, AWTException {
        MainSite main_site = new MainSite("https://campus.gov.il", this.driver);
        try {
            main_site.search_box.sendKeys(TEXT_TO_SEARCH);
            markStepPass("step pass");
            main_site.search_button.click();
            if(TEXT_TO_SEARCH.length()<2){
                driver.findElement(By.xpath("*//div[1]/div/div[6]/div/form/div[2]/span"));
                markStepPass("step pass");
            }else {
            driver.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/div/div/div[2]/p"));
            markStepPass("successful search");}
        }catch(Exception e){markStepFail("Fail");}
    }

}
