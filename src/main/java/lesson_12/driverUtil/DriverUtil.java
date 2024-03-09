package lesson_12.driverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DriverUtil {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void deleteDriver() {
        driver.quit();
        driver = null;
    }

    public static void switchToTab(String url) {
        Set<String> allWindowsHandles = getDriver().getWindowHandles();
        for (String handle : allWindowsHandles) {
            getDriver().switchTo().window(handle);
            if (getDriver().getCurrentUrl().contains(url)) {
                break;
            }
        }
    }

    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public static void dismissConfirm() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        Alert confirm = wait.until(ExpectedConditions.alertIsPresent());
        confirm.dismiss();
    }

    public static void fillInAndAcceptPrompt(String message) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        Alert prompt = wait.until(ExpectedConditions.alertIsPresent());
        prompt.sendKeys(message);
        prompt.accept();
    }
}
