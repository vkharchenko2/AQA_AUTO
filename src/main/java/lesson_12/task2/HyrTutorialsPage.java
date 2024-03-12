package lesson_12.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyrTutorialsPage {

    private WebDriver driver;
    private By alertBoxBtn = By.xpath("//button[@id='alertBox']");
    private By confirmBoxBtn = By.xpath("//button[@id='confirmBox']");
    private By promptBoxBtn= By.xpath("//button[@id='promptBox']");
    private By message = By.xpath("//div[@id='output']");

    public HyrTutorialsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAlertBtn(){
        driver.findElement(alertBoxBtn).click();
    }
     public String getMessage(){
         return driver.findElement(message).getText();
     }

    public void clickOnConfirmBtn(){
        driver.findElement(confirmBoxBtn).click();
    }

    public void clickOnPromptBtn(){
        driver.findElement(promptBoxBtn).click();
    }
}
