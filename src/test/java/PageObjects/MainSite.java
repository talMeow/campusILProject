package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainSite extends PageBase {
    @FindBy(xpath="/html/body/header/div/div[4]/div[1]/span/div/a[1]")
    //Sign in button
    public WebElement button;
    @FindBy(xpath = "/html/body/header/div/div[4]/div[1]/div/div/div[1]/img[2]")
    WebElement open_menu;
    @FindBy(xpath = "/html/body/header/div/div[4]/div[1]/div/div/div[2]/ul/li[4]/a")
    WebElement log_out_button;
    @FindBy(xpath = "//div[4]/div[2]/button")
    WebElement lang_button;
    @FindBy(xpath = "//div[4]/div[2]/div/ul/li")
    List<WebElement> lang_list;
    @FindBy(id = "search-text")
    public WebElement search_box;
    @FindBy(xpath = "*//div[6]/div/form/div[1]/span/button")
    public WebElement search_button;
    @FindBy(xpath = "*//nav/div/ul/li/a")
    public List<WebElement> navigate_buttons;

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

    public void mainSite_language(String lang){
        lang_button.getText();
        if(!lang.equals(lang_button.getText())){
            lang_button.click();
            switch (lang){
                case "עב":
                    lang_list.get(0).click();
                    break;
                case "عربي":
                    lang_list.get(1).click();
                    break;
                case "En":
                    lang_list.get(2).click();
                    break;
            }
        }
    }

    //TODO: SIGN_IN FUNCTION ONLY USED WHEN DOING SIGN_OUT TEST (LOGIN INFO HARDCODDED)


}
