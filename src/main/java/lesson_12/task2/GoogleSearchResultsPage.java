package lesson_12.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class GoogleSearchResultsPage {

    private WebDriver driver;
    private By firstResult = By.xpath("//h3[1]");
    private By inputBar =By.xpath("//textarea[@aria-label='Найти']");

    public GoogleSearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnGuinness() {
        Actions actions = new Actions(driver    );
        actions.keyDown(Keys.CONTROL).click(driver.findElement(firstResult)).keyUp(Keys.CONTROL)
                .build().perform();
    }

    public void deleteInput(){
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(inputBar)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
        .sendKeys(Keys.DELETE)
        .build().perform();
    }

    public void fillingInSearchBar(String tutorials){

        driver.findElement(inputBar).sendKeys(tutorials);
    }

    public void enterClick(){
        driver.findElement(inputBar).sendKeys(Keys.ENTER);
    }

    public void openFirstResultOnANewTab(){
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(firstResult)).keyUp(Keys.CONTROL)
                .build().perform();
    }
}
