import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Set;

public class BaseTest {

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

    @BeforeSuite
    public void setUpSuite(){
        driver = BaseTest.getDriver();
    }

    @AfterSuite
    public void tearDownSuite(){
        BaseTest.deleteDriver();
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
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public static void dismissConfirm() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        Alert confirm = wait.until(ExpectedConditions.alertIsPresent());
        confirm.dismiss();
    }

    public static void fillInAndAcceptPrompt(String message) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        Alert prompt = wait.until(ExpectedConditions.alertIsPresent());
        prompt.sendKeys(message);
        prompt.accept();
    }

    public static String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public static void waitForUrlToChange(String url){
        Wait<WebDriver> wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }
}
