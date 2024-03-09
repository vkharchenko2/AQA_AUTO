package lesson_12.task2;

import lesson_12.driverUtil.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static lesson_12.driverUtil.DriverUtil.getDriver;

public class GoogleMainPage {

    private By searchBar = By.xpath("//textarea[@aria-label='Найти']");
    private By declineButton = By.xpath("//div[text()='Отклонить все']");

    public void fillingInSearchBar(String search) {
        DriverUtil.getDriver().findElement(searchBar).sendKeys(search);
    }

    public void enter() {
        DriverUtil.getDriver().findElement(searchBar).sendKeys(Keys.ENTER);
    }

    public void clickIfCookieIsPresent() {
        List<WebElement> acceptBtn = getDriver().findElements(declineButton);
        if (acceptBtn.size() != 0) {
            acceptBtn.get(0).click();
        }
    }
}
