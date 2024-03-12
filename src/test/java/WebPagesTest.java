import lesson_12.task2.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebPagesTest extends BaseTest{

    private static GoogleMainPage googleMainPage;
    private static GoogleSearchResultsPage googleSearchResultsPage;
    private static GuinnessPage guinnessPage;
    private static HyrTutorialsPage hyrTutorialsPage;
    private static W3SchoolsPage w3SchoolsPage;
    public static final String GOOGLE = "https://www.google.com/search";
    public static final String TUTORIALS = "https://www.hyrtutorials.com/p/alertsdemo.html";
    public static final String GUINNESS_RECORDS = "https://www.guinnessworldrecords.com/account/register?";
    public static final String W_3_SCHOOL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";
    public static final String FIRST_NAME = "Volodymyr";
    public static final String LAST_NAME = "Kharchenko";
    public static final String DAY = "14";
    public static final String MONTH = "11";
    public static final String YEAR = "1996";
    public static final String COUNTRY = "Ukraine";
    public static final String COUNTY = "Sumy";
    public static final String EMAIL = "email@email.ua";
    public static final String PASSWORD = "qwerty";
    public static final String INCORRECT_PASSWORD = "QWRTYasd";
    public static final String PROMPT_MESSAGE = "Final step of this task";

    @BeforeClass
    public void setUpClass(){
        googleMainPage = new GoogleMainPage(getDriver());
        googleSearchResultsPage = new GoogleSearchResultsPage(getDriver());
        guinnessPage = new GuinnessPage(getDriver());
        hyrTutorialsPage = new HyrTutorialsPage(getDriver());
        w3SchoolsPage = new W3SchoolsPage(getDriver());
    }

    @Test
    public void pagesTest() {
        BaseTest.getDriver().get(GOOGLE);
        googleMainPage.clickIfCookieIsPresent();
        googleMainPage.fillingInSearchBar(GUINNESS_RECORDS);
        googleMainPage.enter();
        googleSearchResultsPage.clickOnGuinness();
        googleSearchResultsPage.deleteInput();
        googleSearchResultsPage.fillingInSearchBar(TUTORIALS);
        googleSearchResultsPage.enterClick();
        googleSearchResultsPage.openFirstResultOnANewTab();

        BaseTest.getDriver().get(W_3_SCHOOL);
        BaseTest.switchToTab(W_3_SCHOOL);
        w3SchoolsPage.clickIfCookieIsPresent();
        w3SchoolsPage.deleteFirstName();
        w3SchoolsPage.inputFirstName(FIRST_NAME);
        w3SchoolsPage.deleteLastName();
        w3SchoolsPage.inputLastName(LAST_NAME);
        w3SchoolsPage.clickOnSubmit();
        System.out.println(w3SchoolsPage.getNoteText());

        BaseTest.switchToTab(GUINNESS_RECORDS);
        guinnessPage.inputLastName(LAST_NAME);
        guinnessPage.inputFirstName(FIRST_NAME);
        guinnessPage.inputDay(DAY);
        guinnessPage.inputMonth(MONTH);
        guinnessPage.inputYear(YEAR);
        guinnessPage.inputCountry(COUNTRY);
        guinnessPage.inputCity(COUNTY);
        guinnessPage.inputEmail(EMAIL);
        guinnessPage.confirmEmail(EMAIL);
        guinnessPage.inputPassword(PASSWORD);
        guinnessPage.confirmPassword(INCORRECT_PASSWORD);
        guinnessPage.clickOnPassword();
        System.out.println(guinnessPage.getErrorText());

        BaseTest.switchToTab(TUTORIALS);
        hyrTutorialsPage.clickOnAlertBtn();
        BaseTest.acceptAlert();
        System.out.println(hyrTutorialsPage.getMessage());
        hyrTutorialsPage.clickOnConfirmBtn();
        BaseTest.dismissConfirm();
        System.out.println(hyrTutorialsPage.getMessage());
        hyrTutorialsPage.clickOnPromptBtn();
        BaseTest.fillInAndAcceptPrompt(PROMPT_MESSAGE);
        System.out.println(hyrTutorialsPage.getMessage());
    }
}
