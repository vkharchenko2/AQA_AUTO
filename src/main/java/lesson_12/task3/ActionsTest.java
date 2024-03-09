package lesson_12.task3;

import lesson_12.driverUtil.DriverUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest {

    private static final String REGISTRATION_PAGE = "https://qa-course-01.andersenlab.com/registration";
    private static final String FIRST_NAME = "Sam";
    private static final String LAST_NAME = "Meller";
    private static final String EMAIL = "sam@sam.sam";
    private static final String PASSWORD = "Qwerty3546";
    private static final String DAY = "10";
    private static final String MONTH = "August";
    private static final String YEAR = "1990";
    private static final String REGISTRATION = "registration";

    @Test
    public void registrationTest() {
        DriverUtil.getDriver().get(REGISTRATION_PAGE);
        Registration registration = new Registration();
        Assert.assertTrue(registration.getCurrentURL().contains(REGISTRATION));
        registration.chooseDateOfBirth(MONTH, DAY, YEAR);
        registration.enterKeyWords(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD);
        registration.clickOnSubmitBtn();
        DriverUtil.deleteDriver();
    }
}
