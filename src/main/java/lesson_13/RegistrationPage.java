package lesson_13;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public static final String REGISTRATION_PAGE_URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='Fitst Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder ='Last Name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Date of birth']")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//input[@placeholder='Enter email']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement password;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement confirmPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//span[text()='Invalid email address']")
    private WebElement invalidEmailErrorMessage;
    @FindBy(xpath = "//span[text()='Passwords must match']")
    private WebElement passwordsMustMatchErrorMessage;
    @FindBy(xpath = "//span[text()='Minimum 8 characters']")
    private WebElement shortPasswordErrorMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("method fills in registration data fields")
    public RegistrationPage enterKeyWords(String personalName,
                                          String surname,
                                          String date,
                                          String email,
                                          String keyWord1,
                                          String keyWord2) {
        firstName.sendKeys(personalName);
        lastName.sendKeys(surname);
        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.ENTER);
        emailAddress.sendKeys(email);
        password.sendKeys(keyWord1);
        confirmPassword.sendKeys(keyWord2);
        return this;
    }

    @Step("method clicks on Submit button")
    public RegistrationPage clickOnSubmitBtn() {
        submitBtn.click();
        return this;
    }

    @Step("method checks if invalid email error message is present")
    public boolean isInvalidEmailErrorMessageDisplayed() {
        return invalidEmailErrorMessage.isDisplayed();
    }

    @Step("method checks if the password must match error message is present")
    public boolean isPasswordsMustMatchErrorMessageDisplayed() {
        return passwordsMustMatchErrorMessage.isDisplayed();
    }

    @Step("method checks if the short password error message is present")
    public boolean isShortPasswordErrorMessageDisplayed() {
        return shortPasswordErrorMessage.isDisplayed();
    }
}
