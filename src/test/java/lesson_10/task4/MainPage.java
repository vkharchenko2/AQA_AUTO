package lesson_10.task4;

import lesson_10.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebElement searchInput = DriverUtil.getDriver().findElement(By.xpath("//input[@id='search_query_top']"));
    private WebElement searchBtn = DriverUtil.getDriver().findElement(By.xpath("//button[@name='submit_search']"));
    private WebElement womenBtn = DriverUtil.getDriver().findElement(By.xpath("//a[@title='Women']"));

    public void searchInput(String input) {
        searchInput.sendKeys(input);
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public void clickOnWomenBtn() {
        womenBtn.click();
    }
}
