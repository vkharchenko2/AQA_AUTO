package lesson_10.task1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import lesson_10.utils.DriverUtil;

public class Tests {

    private static final String EMAIL = "v.kharchenko996@gmail.com";
    private static final String PASSWORD = "Poland!1324";
    private static final String WRONG_PASSWORD = "POLand!1324";
    private static final String FIRST_NAME = "Vladimir";
    private static final String LAST_NAME = "Kharchenko";
    private static final String DATE_OF_BIRTH = "11.14.1996";
    private static final String EMAIL_ADDRESS = (Math.random()*100) + "@gmail.com";
    private static final String PAROLE = "Poland!1324";
    private static final String CONFIRM_PAROLE = "Poland!1324";

    @Test
    public void loginTest() {
        SigningIn signingIn = new SigningIn();
        signingIn.enterData(EMAIL, PASSWORD);
        signingIn.clickOnSignInBtn();
        UserPage userPage = new UserPage();
        Assert.assertTrue(userPage.isPageOpen());
    }

    @Test
    public void loginTestCapsLock() {
        SigningIn signingIn = new SigningIn();
        signingIn.enterData(EMAIL, WRONG_PASSWORD);
        signingIn.clickOnSignInBtn();
        Assert.assertTrue(signingIn.isErrorMsgPresent());
    }

    @Test
    public void registrationTest() {
        SigningIn signingIn = new SigningIn();
        signingIn.clickOnRegistrationBtn();
        Registration registration = new Registration();
        Assert.assertTrue(registration.isPageOpen());
        registration.enterKeyWords(FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,EMAIL_ADDRESS,PAROLE,CONFIRM_PAROLE);
        registration.clickOnSubmitBtn();
        UserPage userPage = new UserPage();
        Assert.assertTrue(userPage.isPageOpen());
    }

    @Test
    public void registrationTest1() {
        SigningIn signingIn = new SigningIn();
        signingIn.clickOnRegistrationBtn();
        Registration registration = new Registration();
        Assert.assertTrue(registration.isPageOpen());
        registration.enterKeyWords(FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,EMAIL_ADDRESS,PAROLE,CONFIRM_PAROLE);
        registration.clickOnSubmitBtn();
        // Здесь должен быть метод, который проверяет, что появилось сообщение об ошибке,
        // но такое сообщение не появляется на сайте (TC 013)
    }

    @BeforeMethod
    public static void beforeMethod(){
        DriverUtil.getDriver().get("https://qa-course-01.andersenlab.com/");
    }


    @AfterMethod
    public static void afterMethod() {
        DriverUtil.getDriver().quit();
        DriverUtil.deleteDriver();
    }
}
