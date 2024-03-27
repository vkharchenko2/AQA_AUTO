package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiTextSwitcherPage {


    private AppiumDriver driver;
    private WebDriverWait wait;

    static class Locators {
        private static final By NEXT_BTN = MobileBy.AccessibilityId("Next");
        private static final By CLICKS_COUNTER = By.xpath("//android.widget.TextSwitcher[@resource-id='io.appium.android.apis:id/switcher']/android.widget.TextView");
    }

    public ApiTextSwitcherPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickOnNextBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.NEXT_BTN)).click();
    }

    public String getNumberOfClicks() {
        return driver.findElement(Locators.CLICKS_COUNTER).getText();
    }
}
