package lesson_12.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    private WebDriver driver;
    public static final String REGISTRATION_PAGE = "https://qa-course-01.andersenlab.com/registration";
    private By firstName = By.xpath("//input[@placeholder='Fitst Name']");
    private By lastName = By.xpath("//input[@placeholder ='Last Name']");
    private By email = By.xpath("//input[@placeholder='Enter email']");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By confirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
    private By submitBtn = By.xpath("//button[@type='submit']");
    private By birthDate = By.xpath("//input[@placeholder='Date of birth']");
    private By yearLocator = By.xpath("//div[@class='react-datepicker__month-container']//select[1]");
    private By monthLocator = By.xpath("//div[@class='react-datepicker__month-container']//select[2]");
    private String dayLocatorTemplate = "//div[text()='%s']";

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterKeyWords(String enterFirstName,
                              String enterLastName,
                              String enterEmail,
                              String enterPassword,
                              String enterConfirmPassword) {
        driver.findElement(firstName).sendKeys(enterFirstName);
        driver.findElement(lastName).sendKeys(enterLastName);
        driver.findElement(email).sendKeys(enterEmail);
        driver.findElement(password).sendKeys(enterPassword);
        driver.findElement(confirmPassword).sendKeys(enterConfirmPassword);
    }

    public void clickOnSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public void chooseDateOfBirth(String month, String day, String year) {
        By dateLocator = By.xpath(String.format(dayLocatorTemplate, day));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(birthDate))
                .click(driver.findElement(birthDate))
                .build().perform();
        new Select(driver.findElement(yearLocator)).selectByVisibleText(year);
        new Select(driver.findElement(monthLocator)).selectByVisibleText(month);
        actions.moveToElement(driver.findElement(dateLocator))
                .click(driver.findElement(dateLocator))
                .sendKeys(Keys.ENTER)
                .build().perform();
    }
}
