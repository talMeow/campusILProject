package Tests;

import PageObjects.MainSite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LanguageTest extends BaseTest{
    @Parameters("LANGUAGE")
    @Test
    public void LangTest(String LANGUAGE) throws IOException, AWTException {
        MainSite main_site = new MainSite("https://campus.gov.il", this.driver);
        main_site.mainSite_language(LANGUAGE);
        switch (LANGUAGE){
            case "עב":
                if (main_site.button.equals("התחברות")){
                    markStepPass("language changed");
                } else {markStepFail("Fail");}
                break;
            case "عربي":
                if(main_site.button.equals("تسجيل الدخول")){
                    markStepPass("language changed");
                } else {markStepFail("Fail");}
                break;
            case "En":
                if(main_site.button.equals("Log in")){
                    markStepPass("language changed");
                } else {markStepFail("Fail");}
                break;
        }
    }
}
