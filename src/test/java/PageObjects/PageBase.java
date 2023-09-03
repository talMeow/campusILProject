package PageObjects;

import org.openqa.selenium.WebDriver;
public class PageBase {
    private WebDriver driver;

    protected String url;

    public PageBase(String url, WebDriver driver) {
        this.driver = driver;
        this.url = url;
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }
    //use only when page is loaded
    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    protected void goTo(){
        if(driver==null){
            throw new RuntimeException("driver = null!");
        }
        this.driver.get(url);
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
