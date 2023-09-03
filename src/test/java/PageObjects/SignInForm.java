package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInForm extends PageBase {
    @FindBy(id="login-email")
    WebElement login;

    @FindBy(id="login-password")
    WebElement password;

    @FindBy(xpath="//*[@id=\"login\"]/button")
    WebElement button;

    private static String FRAME_ID = "login-register-iframe";

    public SignInForm(WebDriver driver) throws InterruptedException {
        super(driver);
        Thread.sleep(5000);
        driver.switchTo().frame(FRAME_ID);
        PageFactory.initElements(this.getDriver(),this);
    }

    public void set_user_name(String user_name) {login.sendKeys(user_name);}

    public void set_password(String password) {
        this.password.sendKeys(password);
    }

    public void click_on_sign_in_and_go_to_dashboards_page(){
        this.button.click();
        getDriver().switchTo().parentFrame();
        getDriver().switchTo().defaultContent();
    }
}
