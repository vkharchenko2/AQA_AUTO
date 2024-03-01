package lesson_10.task4;

import lesson_10.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    private WebElement listBtn = DriverUtil.getDriver().findElement(By.xpath("//li[@id='list']"));
    private WebElement searchResults = DriverUtil.getDriver().findElement(By.xpath("//h1[contains(text(),'Search')]"));
    private WebElement addToCompareBtn = DriverUtil.getDriver().findElement(By.xpath("//a[@class='add_to_compare'][1]"));
    private WebElement compareBtn = DriverUtil.getDriver().findElement(By.xpath("//button[@class='btn btn-default button button-medium bt_compare bt_compare'][1]"));
    private static final String COMPARISON_BTN_XPATH ="//strong[@class='total-compare-val' and contains(text(),'%s')]";
    public boolean isPageOpen() {
        return searchResults.isDisplayed();
    }

    public void clickOnListBtn() {
        listBtn.click();
    }

    public void clickOnAddToCompareBtn() {
        addToCompareBtn.click();
    }

    public void clickOnCompareBtn() {
        compareBtn.click();
    }

    public void waitNewNumber(int a) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(COMPARISON_BTN_XPATH, a))));
    }
}
