package lesson_13;


import driverUtil.DriverUtil;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class Tests {

    public static final String ANDERSEN_LAB = "https://qa-course-01.andersenlab.com/registration";
    public static final String ANDERSEN_LAB_LOGIN = "https://qa-course-01.andersenlab.com/login";
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
    private static final String EXISTING_PASSWORD = "uzbekistan";
    private static final String EXISTING_EMAIL = "kdllfk2@gmail.com";


    @Test
    public void registrationBirthDateFromTheFutureTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB);
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH_FROM_THE_FUTURE, EMAIL_ADDRESS, PASSWORD, PASSWORD);
        registrationPage.clickOnSubmitBtn();
        // Здесь должна была быть проверка, что появилось сообщение о некорректной дате.
    }

    @Test
    public void registrationWithInvalidSymbolsInNameAndLastNameTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB);
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterKeyWords(WRONG_NAME, WRONG_LAST_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS, PASSWORD, PASSWORD);
        registrationPage.clickOnSubmitBtn();
        //Здесь должна была быть проверка, что появилось сообщение о некорректном имени и фамилии.
    }

    @Test
    public void registrationInvalidEmailTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB);
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, WRONG_EMAIL_ADDRESS, PASSWORD, PASSWORD);
        registrationPage.clickOnSubmitBtn();
        Assert.assertTrue(registrationPage.isInvalidEmailErrorMessagePresent());
    }

    @Test
    public void registrationNotMatchingPasswordsTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB);
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS, PASSWORD, ANOTHER_PASSWORD);
        registrationPage.clickOnSubmitBtn();
        Assert.assertTrue(registrationPage.isPasswordsMustMatchErrorMessagePresent());
    }

    @Test
    public void registrationShortPasswordTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB);
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS, TOO_SHORT_PASSWORD, TOO_SHORT_PASSWORD);
        registrationPage.clickOnSubmitBtn();
        Assert.assertTrue(registrationPage.isShortPasswordErrorMessagePresent());
    }


    @Test
    public void editFirstNameTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB_LOGIN);
        SignInPage signInPage = new SignInPage();
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD);
        signInPage.clickOnSignInBtn();
        UserPage userPage = new UserPage();
        Assert.assertTrue(userPage.isEditAccBtnDisplayed());
        userPage.clickOnEditAcc();
        EditAccountPage editAccountPage = new EditAccountPage();
        Assert.assertTrue(editAccountPage.isDeleteAccBtnDisplayed());
        editAccountPage.changeName(FIRST_NAME);
        editAccountPage.clickOnSubmit();
        Assert.assertEquals(userPage.getUserName(), FIRST_NAME);
    }

    @Test
    public void editLastNameTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB_LOGIN);
        SignInPage signInPage = new SignInPage();
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD);
        signInPage.clickOnSignInBtn();
        UserPage userPage = new UserPage();
        Assert.assertTrue(userPage.isEditAccBtnDisplayed());
        userPage.clickOnEditAcc();
        EditAccountPage editAccountPage = new EditAccountPage();
        Assert.assertTrue(editAccountPage.isDeleteAccBtnDisplayed());
        editAccountPage.changeLastName(LAST_NAME);
        editAccountPage.clickOnSubmit();
        Assert.assertEquals(userPage.getUserLastName(), LAST_NAME);
    }

    @Test
    public void editMatchingPasswordsTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB_LOGIN);
        SignInPage signInPage = new SignInPage();
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD);
        signInPage.clickOnSignInBtn();
        UserPage userPage = new UserPage();
        Assert.assertTrue(userPage.isEditAccBtnDisplayed());
        userPage.clickOnEditAcc();
        EditAccountPage editAccountPage = new EditAccountPage();
        Assert.assertTrue(editAccountPage.isDeleteAccBtnDisplayed());
        editAccountPage.fillInPasswordsFields(PASSWORD, ANOTHER_PASSWORD);
        editAccountPage.clickOnSubmit();
        Assert.assertTrue(editAccountPage.isPasswordsMustMatchErrorMessagePresent());
    }

    @Test
    public void editShortPasswordTest() {
        DriverUtil.getDriver().get(ANDERSEN_LAB_LOGIN);
        SignInPage signInPage = new SignInPage();
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD);
        signInPage.clickOnSignInBtn();
        UserPage userPage = new UserPage();
        Assert.assertTrue(userPage.isEditAccBtnDisplayed());
        userPage.clickOnEditAcc();
        EditAccountPage editAccountPage = new EditAccountPage();
        Assert.assertTrue(editAccountPage.isDeleteAccBtnDisplayed());
        editAccountPage.shortPassword(TOO_SHORT_PASSWORD, TOO_SHORT_PASSWORD);
        editAccountPage.clickOnSubmit();
        Assert.assertTrue(editAccountPage.isShortPasswordErrorMessagePresent());
    }

    @AfterMethod
    public void afterMethod() {
        DriverUtil.deleteDriver();
    }
}
