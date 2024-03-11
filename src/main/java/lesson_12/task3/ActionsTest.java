package lesson_12.task3;

import lesson_12.driverUtil.DriverUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static lesson_12.task3.RegistrationPage.REGISTRATION_PAGE;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class ActionsTest {

    private static final String FIRST_NAME = "Sam";
    private static final String LAST_NAME = "Mellller";
    private static final String EMAIL = randomAlphabetic(6) + "@sam.sam";
    private static final String PASSWORD = "Qwerty3546";
    private static final String DAY = "10";
    private static final String MONTH = "August";
    private static final String YEAR = "1990";

    @Test
    public void registrationTest() {
        DriverUtil.getDriver().get(REGISTRATION_PAGE);
        RegistrationPage registrationPage = new RegistrationPage();
        Assert.assertEquals(DriverUtil.getCurrentUrl(), REGISTRATION_PAGE, "Registration page is not open");
        registrationPage.chooseDateOfBirth(MONTH, DAY, YEAR);
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD);
        registrationPage.clickOnSubmitBtn();
        DriverUtil.waitForUrlToChange(REGISTRATION_PAGE);
        Assert.assertEquals(DriverUtil.getDriver().getCurrentUrl(), UserPage.USER_PAGE, "User page is not open");
    }

    @AfterMethod
    public void afterMethod(){
        DriverUtil.deleteDriver();
    }
}
