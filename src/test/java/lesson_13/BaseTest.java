package lesson_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownSuite(ITestResult result) {
        if(!result.isSuccess()){
            LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
            List<LogEntry> allLogRows = browserLogs.getAll();
            saveScreenshot(driver);
            if(allLogRows.size()>0){
                saveBrowserLogs(convertToString(allLogRows));
            }
        }
        deleteDriver();
    }

    public static String convertToString(List<LogEntry> logEntryList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LogEntry logEntry : logEntryList) {
            stringBuilder.append(logEntry.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void deleteDriver() {
        driver.quit();
        driver = null;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForUrlToChange(String url) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private static byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser logs", type = "text/plain")
    private static String saveBrowserLogs(String message) {
        return message;
    }
}
