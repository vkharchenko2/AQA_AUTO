package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserPage {

    public static final String USER_PAGE_URL = "https://qa-course-01.andersenlab.com/";
    private WebDriver driver;
    @FindBy(xpath = "//a[text()='Edit account']")
    private WebElement editAccBtn;
    @FindBy(xpath = "//div/p[text()='First name']/following::p[1]")
    private WebElement nameText;
    @FindBy(xpath = "//div/p[text()='Last name']/following::p[1]")
    private WebElement lastNameText;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return nameText.getText();
    }

    public String getUserLastName() {
        return lastNameText.getText();
    }

    public boolean isEditAccBtnDisplayed() {
        return editAccBtn.isDisplayed();
    }

    public UserPage clickOnEditAcc() {
        editAccBtn.click();
        return this;
    }
}
