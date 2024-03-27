package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SwiperUtil;

public class ApiMainPage {

    private static final String DATE_FORMAT_PATTERN_FOR_RESULTS_DATE = "M-dd-yyyy";
    private static final String DATE_FORMAT_PATTERN_FOR_DATE_PICKER = "dd MMMM yyyy";
    private static final String PM = "PM";
    private static final int HOURS_TO_ADD = 12;
    private AppiumDriver driver;
    private WebDriverWait wait;
    private SwiperUtil swiperUtil;

    static class Locators {

        private static final By VIEWS_BTN = MobileBy.AccessibilityId("Views");
    }

    public ApiMainPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        swiperUtil = new SwiperUtil(driver);
    }

    public void clickOnViewsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.VIEWS_BTN)).click();
    }
}
