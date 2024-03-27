import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegrationTest {

    private AppiumDriver driver;

    private final static String HOURS = "11";
    private final static String MINUTES = "01";
    private final static String PART_OF_THE_DAY = "PM";
    private final static int NUMBER_OF_BUTTONS = 42;

    @BeforeClass
    public void precondition() {
        driver = new DriverUtil().getDriver();
    }

    @AfterMethod
    public void postCondition() {
        driver.quit();
    }

    @Test
    public void numbersOfElementsTest() {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        apiMainPage.clickOnViewsBtn();
        List<String> buttonsNamesList = new ArrayList<>();
        buttonsNamesList.addAll(apiMainPage.getNamesOfVisibleButtons());
        for (int i = 0; i < 3; i++) {
            apiMainPage.swipeUp();
            buttonsNamesList.addAll(apiMainPage.getNamesOfVisibleButtons());
        }
        Set<String> buttonsNamesSet = new HashSet<>(buttonsNamesList);
        Assert.assertEquals(buttonsNamesSet.size(), NUMBER_OF_BUTTONS);
    }

    @Test
    public void textSwitcherTest() {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        apiMainPage.clickOnViewsBtn();
        apiMainPage.openTextSwitcher();
        for (int i = 1; i <= 3; i++) {
            apiMainPage.clickOnNextBtn();
            int a = Integer.parseInt(apiMainPage.getNumberOfClicks());
            Assert.assertEquals(a, i);
        }
    }

    @Test
    public void settingDateTest() {
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
        Assert.assertEquals(
                apiMainPage.getCurrentDate(),
                apiMainPage.timeFormat(apiMainPage.getTomorrowDateForResultsDate(), HOURS, MINUTES, PART_OF_THE_DAY));
    }
}
