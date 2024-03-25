import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class ApiMainPage {

    private static final String DATE_FORMAT_PATTERN_FOR_RESULTS_DATE = "M-dd-yyyy";
    private static final String DATE_FORMAT_PATTERN_FOR_DATE_PICKER = "dd MMMM yyyy";
    private static final String PM = "PM";
    private static final int HOURS_TO_ADD = 12;

    public ApiMainPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        swiper = new Swiper(driver);
    }

    static AppiumDriver driver;
    WebDriverWait wait;
    Swiper swiper;

    private static class Locators {

        private static final By VIEWS_BTN = MobileBy.AccessibilityId("Views");
        private static final By TEXT_SWITCHER_BTN = MobileBy.AccessibilityId("TextSwitcher");
        private static final By NEXT_BTN = MobileBy.AccessibilityId("Next");
        private static final By DATE_WIDGETS_BTN = MobileBy.AccessibilityId("Date Widgets");
        private static final By DIALOG_BTN = MobileBy.AccessibilityId("1. Dialog");
        private static final By CHANGE_THE_DATE_BTN = MobileBy.AccessibilityId("change the date");
        private static final By CHANGE_THE_TIME_SPINNER_BTN = MobileBy.AccessibilityId("change the time (spinner)");
        private static final By PART_OF_THE_DAY_INPUT = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.NumberPicker/android.widget.EditText");
        private static final By OK_BTN = By.id("android:id/button1");
        private static final By HOUR_INPUT = By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input'][1]");
        private static final By MINUTE_INPUT = By.xpath("//android.widget.NumberPicker[2]//android.widget.EditText[@resource-id='android:id/numberpicker_input']");
        private static final By DATE_BAR = By.xpath("//android.widget.TextView[@resource-id='io.appium.android.apis:id/dateDisplay']");
        private static final By MINUTE_BTN = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.LinearLayout//android.widget.NumberPicker[2]//android.widget.Button");
        private static final By HOUR_BTN = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.LinearLayout//android.widget.Button[1]");
        private static final By PART_OF_THE_DAY_BTN = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/timePickerLayout']/android.widget.NumberPicker/android.widget.Button");
        private static final By TEXT_VIEW = By.xpath("//android.widget.TextView");
    }

    public void checkNumbersOfElements() {
        List<MobileElement> elements = driver.findElements(Locators.TEXT_VIEW);
        System.out.println("Number of elements: " + elements.size());
    }

    public void clickOnViewsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.VIEWS_BTN)).click();
    }

    public void clickOnNextBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.NEXT_BTN)).click();
    }

    public void clickOnDateWidgetsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DATE_WIDGETS_BTN)).click();
    }

    public void clickOnDialogBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DIALOG_BTN)).click();
    }

    public void clickOnChangeTheDateBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CHANGE_THE_DATE_BTN)).click();
    }

    public void clickOnDayBtn(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(date))).click();
    }

    public void clickOnOkBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.OK_BTN)).click();
    }

    public void clickOnChangeTheTimeBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CHANGE_THE_TIME_SPINNER_BTN)).click();
    }

    public void swipeUp() {
        swiper.swipe(Swiper.Directions.UP);
    }

    public void swipeUpUntilElementFound(By by) {
        while (driver.findElements(by).isEmpty())
            swiper.swipe(Swiper.Directions.UP);
    }

    public void openTextSwitcher() {
        swipeUpUntilElementFound(Locators.TEXT_SWITCHER_BTN);
        driver.findElement(Locators.TEXT_SWITCHER_BTN).click();
    }

    public String getTomorrowDateForResultsDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrowDate = currentDate.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_FOR_RESULTS_DATE);
        return tomorrowDate.format(formatter);
    }

    public String timeFormat(String date, String hours, String minutes, String partOfTheDay) {
        if (partOfTheDay.equals(PM)) {
            hours = String.valueOf(Integer.parseInt(hours) + HOURS_TO_ADD);
        }
        return date + " " + hours + ":" + minutes;
    }

    public String getTomorrowDateForDatePicker() {
        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrowDate = currentDate.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_FOR_DATE_PICKER).withLocale(Locale.ENGLISH);
        return tomorrowDate.format(formatter);
    }

    public void setTime(String enterHour, String enterMinute, String enterPartOfTheDay) {
        Point inputMinuteLocation = driver.findElement(Locators.MINUTE_INPUT).getLocation();
        Point btnMinuteLocation = driver.findElement(Locators.MINUTE_BTN).getLocation();
        String b = driver.findElement(Locators.MINUTE_INPUT).getText();
        while (!b.equals(enterMinute)) {
            new Swiper(driver).swipe(btnMinuteLocation.getX(), btnMinuteLocation.getY(), inputMinuteLocation.getX(), inputMinuteLocation.getY());
            b = driver.findElement(Locators.MINUTE_INPUT).getText();
        }

        Point inputHourLocation = driver.findElement(Locators.HOUR_INPUT).getLocation();
        Point btnHourLocation = driver.findElement(Locators.HOUR_BTN).getLocation();
        String a = driver.findElement(Locators.HOUR_INPUT).getText();
        while (!a.equals(enterHour)) {
            new Swiper(driver).swipe(btnHourLocation.getX(), btnHourLocation.getY(), inputHourLocation.getX(), inputHourLocation.getY());
            a = driver.findElement(Locators.HOUR_INPUT).getText();
        }

        Point inputPartOfTheDayLocation = driver.findElement(Locators.PART_OF_THE_DAY_INPUT).getLocation();
        Point btnPartOfTheDayLocation = driver.findElement(Locators.PART_OF_THE_DAY_BTN).getLocation();
        String c = driver.findElement(Locators.PART_OF_THE_DAY_INPUT).getText();
        while (!c.equals(enterPartOfTheDay)) {
            new Swiper(driver).swipe(btnPartOfTheDayLocation.getX(), btnPartOfTheDayLocation.getY(), inputPartOfTheDayLocation.getX(), inputPartOfTheDayLocation.getY());
            c = driver.findElement(Locators.PART_OF_THE_DAY_INPUT).getText();
        }
    }

    public String getCurrentDate() {
        return driver.findElement(Locators.DATE_BAR).getText();
    }
}
