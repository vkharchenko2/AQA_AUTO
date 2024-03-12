package lesson_13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {

    private WebDriver driver;

    public static final String EDIT_ACCOUNT_URL = "https://qa-course-01.andersenlab.com/editAccount";
    @FindBy(xpath = "//input[@placeholder='Fitst Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder ='Last Name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement password;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement newPassword;
    @FindBy(xpath = "//p[text()='Delete account']")
    private WebElement deleteAccBtn;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//span[text()='Passwords must match']")
    private WebElement passwordsMustMatchErrorMessage;
    @FindBy(xpath = "//span[text()='Minimum 8 characters']")
    private WebElement shortPasswordErrorMessage;

    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDeleteAccBtnDisplayed() {
        return deleteAccBtn.isDisplayed();
    }

    public EditAccountPage clickOnSubmit() {
        submitBtn.click();
        return this;
    }

    public boolean isShortPasswordErrorMessagePresent() {
        return shortPasswordErrorMessage.isDisplayed();
    }

    public boolean isPasswordsMustMatchErrorMessagePresent() {
        return passwordsMustMatchErrorMessage.isDisplayed();
    }

    public EditAccountPage changeName(String name) {
        Actions actions = new Actions(driver);
        actions.click(firstName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        firstName.sendKeys(name);
        return this;
    }

    public EditAccountPage changeLastName(String surname) {
        Actions actions = new Actions(driver);
        actions.click(lastName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        lastName.sendKeys(surname);
        return this;
    }

    public EditAccountPage fillInPasswordsFields(String password1, String password2) {
        password.sendKeys(password1);
        newPassword.sendKeys(password2);
        return this;
    }
}
