package lesson_12.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class W3SchoolsPage {

    private WebDriver driver;
    private By firstNameBar = By.xpath("//input[@id='fname']");
    private By lastNameBar = By.xpath("//input[@id='lname']");
    private By acceptButton = By.xpath("//div[@id='accept-choices']");
    private By iframe = By.xpath("//iframe[@id='iframeResult']");
    private By submitBtn = By.xpath("//input[@type='submit']");
    private By note = By.xpath("//body[@class ='w3-container']/div/p");

    public W3SchoolsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteFirstName() {
        driver.switchTo().frame(driver.findElement(iframe));
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(firstNameBar)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        driver.switchTo().defaultContent();
    }

    public void inputFirstName(String firstName) {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(firstNameBar).sendKeys(firstName);
        driver.switchTo().defaultContent();
    }

    public void deleteLastName() {
        driver.switchTo().frame(driver.findElement(iframe));
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(lastNameBar)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        driver.switchTo().defaultContent();
    }

    public void inputLastName(String lastName) {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(lastNameBar).sendKeys(lastName);
        driver.switchTo().defaultContent();
    }

    public void clickOnSubmit() {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(submitBtn).click();
        driver.switchTo().defaultContent();
    }

    public String getNoteText() {
        driver.switchTo().frame(driver.findElement(iframe));
        String text = driver.findElement(note).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void clickIfCookieIsPresent() {
        List<WebElement> acceptBtn = driver.findElements(acceptButton);
        if (acceptBtn.size() != 0) {
            acceptBtn.get(0).click();
        }
    }
}
