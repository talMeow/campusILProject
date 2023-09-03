package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DashboardsPage extends PageBase {
    @FindBy(xpath = "/html/body/div[3]/header/div[1]/div[2]/div[2]/div[2]/div[1]/span")
    WebElement open_menu;
    @FindBy(xpath = "/html/body/div[3]/header/div[1]/div[2]/div[2]/div[2]/div[2]/div[4]/a")
    WebElement log_out_button;

    public DashboardsPage(String url,WebDriver driver) {
        super(url,driver);
        PageFactory.initElements(this.getDriver(),this);
    }
    public void dashboard_SignOut(){
        open_menu.click();
        log_out_button.click();
    }
}
