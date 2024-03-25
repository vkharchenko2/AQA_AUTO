import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IntegrationTest {

    AppiumDriver driver;

    private final static String HOURS = "11";
    private final static String MINUTES = "01";
    private final static String PART_OF_THE_DAY = "PM";

    @BeforeClass
    public void precondition() {
        driver = new DriverUtil().getDriver();
    }

    @AfterClass
    public void postCondition() {
        driver.quit();
    }

    @Test
    public void numbersOfElementsTest() {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        apiMainPage.clickOnViewsBtn();
        apiMainPage.checkNumbersOfElements();
        apiMainPage.swipeUp();
        apiMainPage.checkNumbersOfElements();
    }

    @Test
    public void textSwitcherTest() {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        apiMainPage.clickOnViewsBtn();
        apiMainPage.openTextSwitcher();
        apiMainPage.clickOnNextBtn();
    }

    @Test
    public void settingDataTest() throws InterruptedException {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        apiMainPage.getTomorrowDateForDatePicker();
        apiMainPage.clickOnViewsBtn();
        apiMainPage.clickOnDateWidgetsBtn();
        apiMainPage.clickOnDialogBtn();
        String result = apiMainPage.getTomorrowDateForDatePicker();
        apiMainPage.clickOnChangeTheDateBtn();
        apiMainPage.clickOnDayBtn(result);
        apiMainPage.clickOnOkBtn();
        apiMainPage.clickOnChangeTheTimeBtn();
        apiMainPage.setTime(HOURS, MINUTES, PART_OF_THE_DAY);
        apiMainPage.clickOnOkBtn();

        Assert.assertEquals(apiMainPage.getCurrentDate(), apiMainPage.timeFormat(apiMainPage.getTomorrowDateForResultsDate(), HOURS,MINUTES, PART_OF_THE_DAY));
    }
}
