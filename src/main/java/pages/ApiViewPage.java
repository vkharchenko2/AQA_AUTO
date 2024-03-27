package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SwiperUtil;

import java.util.ArrayList;
import java.util.List;

public class ApiViewPage {

    private AppiumDriver driver;
    private WebDriverWait wait;
    private SwiperUtil swiperUtil;

    static class Locators {

        private static final By BUTTON_FROM_THE_LIST = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
        private static final By TEXT_SWITCHER_BTN = MobileBy.AccessibilityId("TextSwitcher");
        private static final By DATE_WIDGETS_BTN = MobileBy.AccessibilityId("Date Widgets");
    }

    public ApiViewPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        swiperUtil = new SwiperUtil(driver);
    }

    public List<String> getNamesOfVisibleButtons() {
        List<MobileElement> elements = driver.findElements(Locators.BUTTON_FROM_THE_LIST);
        List<String> names = new ArrayList<>();
        for (MobileElement mobileElement : elements) {
            names.add(mobileElement.getText());
        }
        return names;
    }

    public void swipeUp() {
        swiperUtil.swipe(SwiperUtil.Directions.UP);
    }

    public void swipeUpUntilElementFound(By by) {
        while (driver.findElements(by).isEmpty())
            swiperUtil.swipe(SwiperUtil.Directions.UP);
    }

    public void openTextSwitcher() {
        swipeUpUntilElementFound(Locators.TEXT_SWITCHER_BTN);
        driver.findElement(Locators.TEXT_SWITCHER_BTN).click();
    }

    public void clickOnDateWidgetsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DATE_WIDGETS_BTN)).click();
    }
}
