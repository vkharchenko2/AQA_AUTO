package lesson_10.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lesson_10.utils.DriverUtil;

public class SigningIn {
    private static final String ERROR_MSG_XPATH = "//span[@class='absolute right-0 text-rose-500 text-sm'][1]";
    private WebElement signInBtn = DriverUtil.getDriver().findElement(By.xpath("//button[@type='submit']"));
    private WebElement emailField = DriverUtil.getDriver().findElement(By.xpath("//input[@type = 'text']"));
    private WebElement passwordField = DriverUtil.getDriver().findElement(By.xpath("//input[@type = 'password']"));
    private WebElement registrationBtn = DriverUtil.getDriver().findElement(By.xpath("//a[@class='mt-3 block cursor-pointer hover:underline']"));

    public boolean isErrorMsgPresent(){
        WebElement errorMsg = DriverUtil.getDriver().findElement(By.xpath(ERROR_MSG_XPATH));
        return errorMsg.isDisplayed();
    }
    public void enterData(String enterEmail, String enterPassword){
        emailField.sendKeys(enterEmail);
        passwordField.sendKeys(enterPassword);
    }

    public void clickOnSignInBtn(){
        signInBtn.click();
    }
    public void clickOnRegistrationBtn(){
        registrationBtn.click();
    }
}
