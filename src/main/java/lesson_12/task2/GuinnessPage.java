package lesson_12.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuinnessPage {

    private WebDriver driver;
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

    public GuinnessPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputLastName(String lName){
        driver.findElement(lastName).sendKeys(lName);
    }

    public void inputFirstName(String fName){
        driver.findElement(firstName).sendKeys(fName);
    }

    public void inputDay(String birthDay){
        driver.findElement(day).sendKeys(birthDay);
    }

    public void inputMonth(String birthMonth){
        driver.findElement(month).sendKeys(birthMonth);
    }

    public void inputYear(String birthYear){
        driver.findElement(year).sendKeys(birthYear);
    }

    public void inputCountry(String birthCountry){
        new Select(driver.findElement(country)).selectByVisibleText(birthCountry);
    }

    public void inputCity(String birthCity){
        driver.findElement(county).sendKeys(birthCity);
    }

    public void inputEmail(String emailAddress){
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void confirmEmail(String confirm){
        driver.findElement(confirmEmail).sendKeys(confirm);
    }

    public void inputPassword(String enterPassword){
        driver.findElement(password).sendKeys(enterPassword);
    }

    public void confirmPassword(String verifyPassword){
        driver.findElement(confirmPassword).sendKeys(verifyPassword);
    }

    public String getErrorText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public void clickOnPassword(){
        driver.findElement(confirmPassword).sendKeys(Keys.ENTER);
    }
}
