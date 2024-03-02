package lesson_11.parametrization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogingInPage {

    private WebElement signInBtn = Utils.getDriver().findElement(By.xpath("//button[@type='submit']"));
    private WebElement emailField = Utils.getDriver().findElement(By.xpath("//input[@type = 'text']"));
    private WebElement passwordField = Utils.getDriver().findElement(By.xpath("//input[@type = 'password']"));

    public void enterData(String enterEmail, String enterPassword) {
        emailField.sendKeys(enterEmail);
        passwordField.sendKeys(enterPassword);
    }

    public void clickOnSignInBtn() {
        signInBtn.click();
    }
}
