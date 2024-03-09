package lesson_12.task2;

import org.openqa.selenium.By;
import static lesson_12.driverUtil.DriverUtil.*;

public class HyrTutorialsPage {

    private By alertBoxBtn = By.xpath("//button[@id='alertBox']");
    private By confirmBoxBtn = By.xpath("//button[@id='confirmBox']");
    private By promptBoxBtn= By.xpath("//button[@id='promptBox']");
    private By message = By.xpath("//div[@id='output']");

    public void clickOnAlertBtn(){
        getDriver().findElement(alertBoxBtn).click();
    }
     public String getMessage(){
         return getDriver().findElement(message).getText();
     }

    public void clickOnConfirmBtn(){
        getDriver().findElement(confirmBoxBtn).click();
    }

    public void clickOnPromptBtn(){
        getDriver().findElement(promptBoxBtn).click();
    }
}
