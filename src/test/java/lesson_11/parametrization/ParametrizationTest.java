package lesson_11.parametrization;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationTest {

    private static final String PAGE = "https://qa-course-01.andersenlab.com/";

    @DataProvider(name = "login")
    public Object[][] login() {
        return new Object[][]{
                {"v.kharchenko996@gmail.com", "qwerty"},
                {"alex@gmail.com", "ukraina1234"},
                {"mukha03@gmail.com", "uzbekistan"}
        };
    }

    @Test(dataProvider = "login")
    public void loginTestDataProvider(String email, String password) {
        Utils.getDriver().get(PAGE);
        LogingInPage logingInPage = new LogingInPage();
        logingInPage.enterData(email, password);
        logingInPage.clickOnSignInBtn();
    }

    @Test
    @Parameters({"email", "password"})
    public void loginTestParameters(String email, String password) {
        Utils.getDriver().get(PAGE);
        LogingInPage logingInPage = new LogingInPage();
        logingInPage.enterData(email, password);
        logingInPage.clickOnSignInBtn();
    }

    @AfterMethod
    public void afterMethod() {
        Utils.getDriver().quit();
        Utils.deleteDriver();
    }
}
