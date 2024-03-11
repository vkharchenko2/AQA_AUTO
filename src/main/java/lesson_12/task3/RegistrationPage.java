package lesson_12.task3;

import lesson_12.driverUtil.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

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

    public void enterKeyWords(String enterFirstName,
                              String enterLastName,
                              String enterEmail,
                              String enterPassword,
                              String enterConfirmPassword) {
        DriverUtil.getDriver().findElement(firstName).sendKeys(enterFirstName);
        DriverUtil.getDriver().findElement(lastName).sendKeys(enterLastName);
        DriverUtil.getDriver().findElement(email).sendKeys(enterEmail);
        DriverUtil.getDriver().findElement(password).sendKeys(enterPassword);
        DriverUtil.getDriver().findElement(confirmPassword).sendKeys(enterConfirmPassword);
    }

    public void clickOnSubmitBtn() {
        DriverUtil.getDriver().findElement(submitBtn).click();
    }

    public void chooseDateOfBirth(String month, String day, String year) {
        By dateLocator = By.xpath(String.format(dayLocatorTemplate, day));
        Actions actions = new Actions(DriverUtil.getDriver());
        actions.moveToElement(DriverUtil.getDriver().findElement(birthDate))
                .click(DriverUtil.getDriver().findElement(birthDate))
                .build().perform();
        new Select(DriverUtil.getDriver().findElement(yearLocator)).selectByVisibleText(year);
        new Select(DriverUtil.getDriver().findElement(monthLocator)).selectByVisibleText(month);
        actions.moveToElement(DriverUtil.getDriver().findElement(dateLocator))
                .click(DriverUtil.getDriver().findElement(dateLocator))
                .sendKeys(Keys.ENTER)
                .build().perform();
    }
}
