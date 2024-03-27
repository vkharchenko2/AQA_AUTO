package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SwiperUtil;


public class ApiDialogPage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    static class Locators {
        private static final By CHANGE_THE_DATE_BTN = MobileBy.AccessibilityId("change the date");
        private static final By OK_BTN = By.id("android:id/button1");
        private static final By CHANGE_THE_TIME_SPINNER_BTN = MobileBy.AccessibilityId("change the time (spinner)");
        private static final By DATE_BAR = By.xpath("//android.widget.TextView[@resource-id='io.appium.android.apis:id/dateDisplay']");
        private static final By HOUR_INPUT = By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input'][1]");
        private static final By PART_OF_THE_DAY_INPUT = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.NumberPicker/android.widget.EditText");
        private static final By MINUTE_INPUT = By.xpath("//android.widget.NumberPicker[2]//android.widget.EditText[@resource-id='android:id/numberpicker_input']");
        private static final By MINUTE_BTN = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.LinearLayout//android.widget.NumberPicker[2]//android.widget.Button");
        private static final By HOUR_BTN = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.LinearLayout//android.widget.Button[1]");
        private static final By PART_OF_THE_DAY_BTN = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.NumberPicker/android.widget.Button");
    }

    public ApiDialogPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickOnDayBtn(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(date))).click();
    }

    public void clickOnChangeTheDateBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CHANGE_THE_DATE_BTN)).click();
    }

    public void clickOnOkBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.OK_BTN)).click();
    }

    public void clickOnChangeTheTimeBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CHANGE_THE_TIME_SPINNER_BTN)).click();
    }

    public String getCurrentDate() {
        return driver.findElement(Locators.DATE_BAR).getText();
    }

    public void setTime(String enterHour, String enterMinute, String enterPartOfTheDay) {
        Point inputMinuteLocation = driver.findElement(Locators.MINUTE_INPUT).getLocation();
        Point btnMinuteLocation = driver.findElement(Locators.MINUTE_BTN).getLocation();
        String minuteInputText = driver.findElement(Locators.MINUTE_INPUT).getText();
        while (!minuteInputText.equals(enterMinute)) {
            new SwiperUtil(driver).swipe(btnMinuteLocation.getX(), btnMinuteLocation.getY(), inputMinuteLocation.getX(), inputMinuteLocation.getY());
            minuteInputText = driver.findElement(Locators.MINUTE_INPUT).getText();
        }

        Point inputHourLocation = driver.findElement(Locators.HOUR_INPUT).getLocation();
        Point btnHourLocation = driver.findElement(Locators.HOUR_BTN).getLocation();
        String hourInputText = driver.findElement(Locators.HOUR_INPUT).getText();
        while (!hourInputText.equals(enterHour)) {
            new SwiperUtil(driver).swipe(btnHourLocation.getX(), btnHourLocation.getY(), inputHourLocation.getX(), inputHourLocation.getY());
            hourInputText = driver.findElement(Locators.HOUR_INPUT).getText();
        }

        Point inputPartOfTheDayLocation = driver.findElement(Locators.PART_OF_THE_DAY_INPUT).getLocation();
        Point btnPartOfTheDayLocation = driver.findElement(Locators.PART_OF_THE_DAY_BTN).getLocation();
        String partOfTheDayInputText = driver.findElement(Locators.PART_OF_THE_DAY_INPUT).getText();
        while (!partOfTheDayInputText.equals(enterPartOfTheDay)) {
            new SwiperUtil(driver).swipe(btnPartOfTheDayLocation.getX(), btnPartOfTheDayLocation.getY(), inputPartOfTheDayLocation.getX(), inputPartOfTheDayLocation.getY());
            partOfTheDayInputText = driver.findElement(Locators.PART_OF_THE_DAY_INPUT).getText();
        }
    }
}
