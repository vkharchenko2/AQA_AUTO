package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Open {string} page")
    public void open_page(String string) {
        Configuration.timeout = 60000;
        Selenide.open(string);
        }
    }
