package lesson_12.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static lesson_12.driverUtil.DriverUtil.*;

public class GoogleSearchResultsPage {

    private By firstResult = By.xpath("//h3[1]");
    private By inputBar =By.xpath("//textarea[@aria-label='Найти']");

    public void clickOnGuinness() {
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL).click(getDriver().findElement(firstResult)).keyUp(Keys.CONTROL)
                .build().perform();
    }

    public void deleteInput(){
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(inputBar)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
        .sendKeys(Keys.DELETE)
        .build().perform();
    }

    public void fillingInSearchBar(String tutorials){

        getDriver().findElement(inputBar).sendKeys(tutorials);
    }

    public void enterClick(){
        getDriver().findElement(inputBar).sendKeys(Keys.ENTER);
    }

    public void openFirstResultOnANewTab(){
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL).click(getDriver().findElement(firstResult)).keyUp(Keys.CONTROL)
                .build().perform();
    }
}
