package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiDateWidgetsPage {

    static class Locators {

        private static final By DIALOG_BTN = MobileBy.AccessibilityId("1. Dialog");
    }

    private AppiumDriver driver;
    private WebDriverWait wait;

    public ApiDateWidgetsPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickOnDialogBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DIALOG_BTN)).click();
    }
}
