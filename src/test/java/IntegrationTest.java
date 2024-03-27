import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.DateUtil;
import utils.DriverUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegrationTest {

    private AppiumDriver driver;

    private final static String HOURS = "11";
    private final static String MINUTES = "11";
    private final static String PART_OF_THE_DAY = "PM";
    private final static int NUMBER_OF_BUTTONS = 42;

    @BeforeMethod
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
        ApiViewPage apiViewPage = new ApiViewPage(driver);
        apiMainPage.clickOnViewsBtn();
        List<String> buttonsNamesList = new ArrayList<>();
        buttonsNamesList.addAll(apiViewPage.getNamesOfVisibleButtons());
        for (int i = 0; i < 3; i++) {
            apiViewPage.swipeUp();
            buttonsNamesList.addAll(apiViewPage.getNamesOfVisibleButtons());
        }
        Set<String> buttonsNamesSet = new HashSet<>(buttonsNamesList);
        Assert.assertEquals(buttonsNamesSet.size(), NUMBER_OF_BUTTONS,"Number of buttons does not match test data");
    }

    @Test
    public void textSwitcherTest() {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        ApiViewPage apiViewPage= new ApiViewPage(driver);
        ApiTextSwitcherPage apiTextSwitcherPage = new ApiTextSwitcherPage(driver);
        apiMainPage.clickOnViewsBtn();
        apiViewPage.openTextSwitcher();
        for (int i = 1; i <= 3; i++) {
            apiTextSwitcherPage.clickOnNextBtn();
            int a = Integer.parseInt(apiTextSwitcherPage.getNumberOfClicks());
            Assert.assertEquals(a, i,"Value on the screen does not match with a number od clicks");
        }
    }

    @Test
    public void settingDateTest() {
        ApiMainPage apiMainPage = new ApiMainPage(driver);
        ApiViewPage apiViewPage = new ApiViewPage(driver);
        ApiDateWidgetsPage apiDateWidgetsPage = new ApiDateWidgetsPage(driver);
        ApiDialogPage apiDialogPage = new ApiDialogPage(driver);
        apiMainPage.clickOnViewsBtn();
        apiViewPage.clickOnDateWidgetsBtn();
        apiDateWidgetsPage.clickOnDialogBtn();
        String result = DateUtil.getTomorrowDateForDatePicker();
        apiDialogPage.clickOnChangeTheDateBtn();
        apiDialogPage.clickOnDayBtn(result);
        apiDialogPage.clickOnOkBtn();
        apiDialogPage.clickOnChangeTheTimeBtn();
        apiDialogPage.setTime(HOURS, MINUTES, PART_OF_THE_DAY);
        apiDialogPage.clickOnOkBtn();
        Assert.assertEquals(
                apiDialogPage.getCurrentDate(),
                DateUtil.timeFormat(DateUtil.getTomorrowDateForResultsDate(), HOURS, MINUTES, PART_OF_THE_DAY),
                "Date on the screen does not match with input date");
    }
}
