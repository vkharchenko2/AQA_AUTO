package lesson_12.task2;

import lesson_12.driverUtil.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static lesson_12.driverUtil.DriverUtil.*;

public class W3SchoolsPage {

    private By firstNameBar = By.xpath("//input[@id='fname']");
    private By lastNameBar = By.xpath("//input[@id='lname']");
    private By acceptButton = By.xpath("//div[@id='accept-choices']");
    private By iframe = By.xpath("//iframe[@id='iframeResult']");
    private By submitBtn = By.xpath("//input[@type='submit']");
    private By note = By.xpath("//body[@class ='w3-container']/div/p");

    public void deleteFirstName() {
        DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(iframe));
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(firstNameBar)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        DriverUtil.getDriver().switchTo().defaultContent();
    }

    public void inputFirstName(String firstName) {
        DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(iframe));
        getDriver().findElement(firstNameBar).sendKeys(firstName);
        DriverUtil.getDriver().switchTo().defaultContent();
    }

    public void deleteLastName() {
        DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(iframe));
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(lastNameBar)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        DriverUtil.getDriver().switchTo().defaultContent();
    }

    public void inputLastName(String lastName) {
        DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(iframe));
        getDriver().findElement(lastNameBar).sendKeys(lastName);
        DriverUtil.getDriver().switchTo().defaultContent();
    }

    public void clickOnSubmit() {
        DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(iframe));
        getDriver().findElement(submitBtn).click();
        DriverUtil.getDriver().switchTo().defaultContent();
    }

    public String getNoteText() {
        DriverUtil.getDriver().switchTo().frame(DriverUtil.getDriver().findElement(iframe));
        String text = getDriver().findElement(note).getText();
        DriverUtil.getDriver().switchTo().defaultContent();
        return text;
    }

    public void clickIfCookieIsPresent() {
        List<WebElement> acceptBtn = getDriver().findElements(acceptButton);
        if (acceptBtn.size() != 0) {
            acceptBtn.get(0).click();
        }
    }
}
