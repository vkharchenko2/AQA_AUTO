import lesson_12.task3.RegistrationPage;
import lesson_12.task3.UserPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static lesson_12.task3.RegistrationPage.REGISTRATION_PAGE;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RegistrationPageTest extends BaseTest {

    private static RegistrationPage registrationPage;
    private static final String FIRST_NAME = "Sam";
    private static final String LAST_NAME = "Mellller";
    private static final String EMAIL = randomAlphabetic(6) + "@sam.sam";
    private static final String PASSWORD = "Qwerty3546";
    private static final String DAY = "10";
    private static final String MONTH = "August";
    private static final String YEAR = "1990";

    @BeforeClass
    public void setUpClass() {
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationTest() {
        BaseTest.getDriver().get(REGISTRATION_PAGE);
        Assert.assertEquals(BaseTest.getCurrentUrl(), REGISTRATION_PAGE, "Registration page is not open");
        registrationPage.chooseDateOfBirth(MONTH, DAY, YEAR);
        registrationPage.enterKeyWords(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD);
        registrationPage.clickOnSubmitBtn();
        BaseTest.waitForUrlToChange(REGISTRATION_PAGE);
        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), UserPage.USER_PAGE, "User page is not open");
    }
}
