package lesson_12.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMainPage {
    private WebDriver driver;
    private By searchBar = By.xpath("//textarea[@aria-label='Найти' or @aria-label='Google Search']");
    private By declineButton = By.xpath("//div[text()='Отклонить все' or text()='Reject all']");

    public GoogleMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillingInSearchBar(String search) {
        driver.findElement(searchBar).sendKeys(search);
    }

    public void enter() {
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }

    public void clickIfCookieIsPresent() {
        List<WebElement> acceptBtn = driver.findElements(declineButton);
        if (acceptBtn.size() != 0) {
            acceptBtn.get(0).click();
        }
    }
}
