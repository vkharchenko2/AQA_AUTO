package steps;


import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class AfterStep {

    @After
    public void tear_down(){
        Selenide.closeWebDriver();
    }

}
