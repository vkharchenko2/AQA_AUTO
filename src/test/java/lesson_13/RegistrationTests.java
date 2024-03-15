package lesson_13;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson_13.RegistrationPage.REGISTRATION_PAGE_URL;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RegistrationTests extends BaseTest {

    private static EditAccountPage editAccountPage;
    private static RegistrationPage registrationPage;
    private static SignInPage signInPage;
    private static UserPage userPage;
    private static final String PASSWORD = randomAlphabetic(8);
    private static final String ANOTHER_PASSWORD = randomAlphabetic(8);

    private static final String WRONG_NAME = "Fatima^&%";
    private static final String FIRST_NAME = randomAlphabetic(8);
    private static final String WRONG_LAST_NAME = "Bayeva@%&";
    private static final String LAST_NAME = randomAlphabetic(7);
    private static final String DATE_OF_BIRTH_FROM_THE_FUTURE = "03.01.2054";
    private static final String DATE_OF_BIRTH = "05.03.1999";
    private static final String WRONG_EMAIL_ADDRESS = randomAlphabetic(4) + ".gmail com";
    public static final String EMAIL_ADDRESS = randomAlphabetic(6) + "@gmail.com";
    private static final String TOO_SHORT_PASSWORD = randomAlphabetic(6);

    @BeforeMethod
    public void setUpClass() {
        editAccountPage = new EditAccountPage(driver);
        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver);
        userPage = new UserPage(driver);
    }

    @Test(description = "Test checks possibility of registration with a date from the future")
    public void registrationBirthDateFromTheFutureTest() {
        driver.get(REGISTRATION_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), REGISTRATION_PAGE_URL, "Registration page is not open");
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH_FROM_THE_FUTURE, EMAIL_ADDRESS, PASSWORD, PASSWORD)
                .clickOnSubmitBtn();
        // Здесь должна была быть проверка, что появилось сообщение о некорректной дате.
    }

    @Test(description = "Test checks possibility of registration with an invalid symbols in user's first and last name")
    public void registrationWithInvalidSymbolsInNameAndLastNameTest() {
        driver.get(REGISTRATION_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), REGISTRATION_PAGE_URL, "Registration page is not open");
        registrationPage.enterKeyWords(WRONG_NAME, WRONG_LAST_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS, PASSWORD, PASSWORD)
                .clickOnSubmitBtn();
        //Здесь должна была быть проверка, что появилось сообщение о некорректном имени и фамилии.
    }

    @Test(description = "Test checks possibility of registration without an @ in email address")
    public void registrationWithoutAtSignInEmailTest() {
        driver.get(REGISTRATION_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), REGISTRATION_PAGE_URL, "Registration page is not open");
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, WRONG_EMAIL_ADDRESS, PASSWORD, PASSWORD)
                .clickOnSubmitBtn();
        Assert.assertTrue(registrationPage.isInvalidEmailErrorMessageDisplayed(), "Invalid email error message is not displayed");
    }

    @Test(description = "Test check if passwords must match error message is present")
    public void passwordsMustMatchErrorMessageTest() {
        driver.get(REGISTRATION_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), REGISTRATION_PAGE_URL, "Registration page is not open");
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS, PASSWORD, ANOTHER_PASSWORD)
                .clickOnSubmitBtn();
        Assert.assertTrue(registrationPage.isPasswordsMustMatchErrorMessageDisplayed(), "Passwords must match error message is not displayed");
    }

    @Test(description = "Test check if minimum 8 characters error message is present")
    public void minimum8CharactersErrorMessageTest() {
        driver.get(REGISTRATION_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), REGISTRATION_PAGE_URL, "Registration page is not open");
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS, TOO_SHORT_PASSWORD, TOO_SHORT_PASSWORD)
                .clickOnSubmitBtn();
        Assert.assertTrue(registrationPage.isShortPasswordErrorMessageDisplayed(), "Minimum 8 characters error message is not displayed");
    }
}
