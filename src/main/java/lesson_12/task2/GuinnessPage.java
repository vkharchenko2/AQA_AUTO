package lesson_12.task2;

import lesson_12.driverUtil.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static lesson_12.driverUtil.DriverUtil.*;

public class GuinnessPage {

    private By lastName = By.xpath("//input[@name='LastName']");
    private By firstName = By.xpath("//input[@name='FirstName']");
    private By day = By.xpath("//input[@id='DateOfBirthDay']");
    private By month = By.xpath("//input[@id='DateOfBirthMonth']");
    private By year = By.xpath("//input[@id='DateOfBirthYear']");
    private By country = By.xpath("//select[@name='Country']");
    private By county = By.xpath("//input[@name='State']");
    private By email = By.xpath("//input[@name='EmailAddress']");
    private By confirmEmail = By.xpath("//input[@name='ConfirmEmailAddress']");
    private By password = By.xpath("//input[@name='Password']");
    private By confirmPassword = By.xpath("//input[@name='ConfirmPassword']");
    private By errorMessage= By.xpath("//span[@for='ConfirmPassword']");

    public void inputLastName(String lName){
        getDriver().findElement(lastName).sendKeys(lName);
    }

    public void inputFirstName(String fName){
        getDriver().findElement(firstName).sendKeys(fName);
    }

    public void inputDay(String birthDay){
        getDriver().findElement(day).sendKeys(birthDay);
    }

    public void inputMonth(String birthMonth){
        getDriver().findElement(month).sendKeys(birthMonth);
    }

    public void inputYear(String birthYear){
        getDriver().findElement(year).sendKeys(birthYear);
    }

    public void inputCountry(String birthCountry){
        new Select(DriverUtil.getDriver().findElement(country)).selectByVisibleText(birthCountry);
    }

    public void inputCity(String birthCity){
        getDriver().findElement(county).sendKeys(birthCity);
    }

    public void inputEmail(String emailAddress){
        getDriver().findElement(email).sendKeys(emailAddress);
    }

    public void confirmEmail(String confirm){
        getDriver().findElement(confirmEmail).sendKeys(confirm);
    }

    public void inputPassword(String enterPassword){
        getDriver().findElement(password).sendKeys(enterPassword);
    }

    public void confirmPassword(String verifyPassword){
        getDriver().findElement(confirmPassword).sendKeys(verifyPassword);
    }

    public String getErrorText(){
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return getDriver().findElement(errorMessage).getText();
    }

    public void clickOnPassword(){
        getDriver().findElement(confirmPassword).sendKeys(Keys.ENTER);
    }
}
