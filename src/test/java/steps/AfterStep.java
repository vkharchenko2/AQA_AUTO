package steps;


import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class AfterStep {

    @After
    public void tear_down(){
        Selenide.closeWebDriver();
//        WebDriverRunner.getWebDriver().quit();
    }

//    @io.cucumber.java.AfterStep
//    public void make_screenshot(){
//        Selenide.screenshot(System.currentTimeMillis() + "step");
//    }
}
