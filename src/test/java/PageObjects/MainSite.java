package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainSite extends PageBase {
    @FindBy(xpath="/html/body/header/div/div[4]/div[1]/span/div/a[1]")
    WebElement button;
    @FindBy(xpath = "/html/body/header/div/div[4]/div[1]/div/div/div[1]/img[2]")
    WebElement open_menu;
    @FindBy(xpath = "/html/body/header/div/div[4]/div[1]/div/div/div[2]/ul/li[4]/a")
    WebElement log_out_button;

    public MainSite(String url,WebDriver driver) {
        super(url,driver);
        PageFactory.initElements(this.getDriver(),this);
    }
    /*public MainSite(String url){
        super(url);
    }*/

    public SignInForm clickOnSignInAndGoToSignInPage() throws InterruptedException {
        button.click();
        return new SignInForm(getDriver());
    }

    public void mainSite_SignOut(){
        open_menu.click();
        log_out_button.click();
    }

    //TODO: SIGN_IN FUNCTION ONLY USED WHEN DOING SIGN_OUT TEST (LOGIN INFO HARDCODDED)


}
