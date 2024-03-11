package lesson_13;

import org.openqa.selenium.By;
import static driverUtil.DriverUtil.*;

public class SignInPage {

    private By email = By.xpath("//input[@placeholder='Enter email']");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By signInBtn = By.xpath("//button[@type='submit']");

    public void enterData(String emailAddress, String keyWord){
        getDriver().findElement(email).sendKeys(emailAddress);
        getDriver().findElement(password).sendKeys(keyWord);
    }

    public void clickOnSignInBtn(){
        getDriver().findElement(signInBtn).click();
    }
}
