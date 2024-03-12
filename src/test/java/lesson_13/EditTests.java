package lesson_13;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson_13.EditAccountPage.EDIT_ACCOUNT_URL;
import static lesson_13.SignInPage.LOGIN_PAGE_URL;
import static lesson_13.UserPage.USER_PAGE_URL;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class EditTests extends BaseTest {

    private static EditAccountPage editAccountPage;
    private static SignInPage signInPage;
    private static UserPage userPage;
    private static final String PASSWORD = randomAlphabetic(8);
    private static final String ANOTHER_PASSWORD = randomAlphabetic(8);
    private static final String FIRST_NAME = randomAlphabetic(8);
    private static final String LAST_NAME = randomAlphabetic(7);
    private static final String TOO_SHORT_PASSWORD = randomAlphabetic(6);
    private static final String EXISTING_PASSWORD = "uzbekistan";
    private static final String EXISTING_EMAIL = "kdllfk2@gmail.com";

    @BeforeMethod
    public void setUpClass() {
        editAccountPage = new EditAccountPage(driver);
        signInPage = new SignInPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    public void editFirstNameTest() {
        driver.get(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), LOGIN_PAGE_URL, "Login page is not open");
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD)
                .clickOnSignInBtn();
        waitForUrlToChange(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), USER_PAGE_URL, "User page is not open");
        userPage.clickOnEditAcc();
        waitForUrlToChange(USER_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), EDIT_ACCOUNT_URL, "Edit account page is not open");
        editAccountPage.changeName(FIRST_NAME)
                .clickOnSubmit();
        waitForUrlToChange(EDIT_ACCOUNT_URL);
        Assert.assertEquals(getCurrentUrl(), USER_PAGE_URL, "User page is not open");
        Assert.assertEquals(userPage.getUserName(), FIRST_NAME, "Names are not equal");
    }

    @Test
    public void editLastNameTest() {
        driver.get(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), LOGIN_PAGE_URL,"Login page is not open");
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD)
                .clickOnSignInBtn();
        waitForUrlToChange(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), USER_PAGE_URL, "User page is not open");
        userPage.clickOnEditAcc();
        waitForUrlToChange(USER_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), EDIT_ACCOUNT_URL, "Edit account page is not open");
        editAccountPage.changeLastName(LAST_NAME)
                .clickOnSubmit();
        waitForUrlToChange(EDIT_ACCOUNT_URL);
        Assert.assertEquals(getCurrentUrl(), USER_PAGE_URL, "User page is not open");
        Assert.assertEquals(userPage.getUserName(), FIRST_NAME, "Names are not equal");
    }

    @Test
    public void editMatchingPasswordsTest() {
        driver.get(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), LOGIN_PAGE_URL,"Login page is not open");
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD)
                .clickOnSignInBtn();
        waitForUrlToChange(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), USER_PAGE_URL, "User page is not open");
        userPage.clickOnEditAcc();
        waitForUrlToChange(USER_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), EDIT_ACCOUNT_URL, "Edit account page is not open");
        editAccountPage.fillInPasswordsFields(PASSWORD, ANOTHER_PASSWORD)
                .clickOnSubmit();
        Assert.assertTrue(editAccountPage.isPasswordsMustMatchErrorMessagePresent(), "Passwords must match error message is not present");
    }

    @Test
    public void editShortPasswordTest() {
        driver.get(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), LOGIN_PAGE_URL,"Login page is not open");
        signInPage.enterData(EXISTING_EMAIL, EXISTING_PASSWORD)
                .clickOnSignInBtn();
        waitForUrlToChange(LOGIN_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), USER_PAGE_URL, "User page is not open");
        userPage.clickOnEditAcc();
        waitForUrlToChange(USER_PAGE_URL);
        Assert.assertEquals(getCurrentUrl(), EDIT_ACCOUNT_URL, "Edit account page is not open");
        editAccountPage.fillInPasswordsFields(TOO_SHORT_PASSWORD, TOO_SHORT_PASSWORD)
                .clickOnSubmit();
        Assert.assertTrue(editAccountPage.isShortPasswordErrorMessagePresent(),"Minimum 8 characters error message is not present");
    }
}
