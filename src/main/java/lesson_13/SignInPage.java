package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public static final String LOGIN_PAGE_URL = "https://qa-course-01.andersenlab.com/login";
    private WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='Enter email']")
    private WebElement email;
    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInBtn;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SignInPage enterData(String emailAddress, String keyWord) {
        email.sendKeys(emailAddress);
        password.sendKeys(keyWord);
        return this;
    }

    public SignInPage clickOnSignInBtn() {
        signInBtn.click();
        return this;
    }
}
