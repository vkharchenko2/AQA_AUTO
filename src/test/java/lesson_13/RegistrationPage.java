package lesson_13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static driverUtil.DriverUtil.*;

public class RegistrationPage {

    private By firstName = By.xpath("//input[@placeholder='Fitst Name']");
    private By lastName = By.xpath("//input[@placeholder ='Last Name']");
    private By dateOfBirth = By.xpath("//input[@placeholder='Date of birth']");
    private By emailAddress = By.xpath("//input[@placeholder='Enter email']");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By confirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
    private By submitBtn = By.xpath("//button[@type='submit']");
    private By invalidEmailErrorMessage = By.xpath("//span[text()='Invalid email address']");
    private By passwordsMustMatchErrorMessage = By.xpath("//span[text()='Passwords must match']");
    private By shortPasswordErrorMessage = By.xpath("//span[text()='Minimum 8 characters']");

    public void enterKeyWords(String personalName, String surname, String date, String email, String keyWord1, String keyWord2) {
        getDriver().findElement(firstName).sendKeys(personalName);
        getDriver().findElement(lastName).sendKeys(surname);
        getDriver().findElement(dateOfBirth).sendKeys(date);
        getDriver().findElement(dateOfBirth).sendKeys(Keys.ENTER);
        getDriver().findElement(emailAddress).sendKeys(email);
        getDriver().findElement(password).sendKeys(keyWord1);
        getDriver().findElement(confirmPassword).sendKeys(keyWord2);
    }

    public void clickOnSubmitBtn() {
        getDriver().findElement(submitBtn).click();
    }

    public boolean isInvalidEmailErrorMessagePresent() {
        return getDriver().findElement(invalidEmailErrorMessage).isDisplayed();
    }

    public boolean isPasswordsMustMatchErrorMessagePresent() {
        return getDriver().findElement(passwordsMustMatchErrorMessage).isDisplayed();
    }

    public boolean isShortPasswordErrorMessagePresent() {
        return getDriver().findElement(shortPasswordErrorMessage).isDisplayed();
    }
}
