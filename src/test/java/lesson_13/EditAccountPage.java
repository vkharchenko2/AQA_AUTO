package lesson_13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static driverUtil.DriverUtil.getDriver;

public class EditAccountPage {

    private By firstName = By.xpath("//input[@placeholder='Fitst Name']");
    private By lastName = By.xpath("//input[@placeholder ='Last Name']");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By newPassword = By.xpath("//input[@placeholder='Confirm Password']");
    private By deleteAccBtn = By.xpath("//p[text()='Delete account']");
    private By submitBtn = By.xpath("//button[@type='submit']");
    private By passwordsMustMatchErrorMessage = By.xpath("//span[text()='Passwords must match']");
    private By shortPasswordErrorMessage = By.xpath("//span[text()='Minimum 8 characters']");

    public boolean isDeleteAccBtnDisplayed() {
        return getDriver().findElement(deleteAccBtn).isDisplayed();
    }

    public void clickOnSubmit() {
        getDriver().findElement(submitBtn).click();
    }

    public boolean isShortPasswordErrorMessagePresent() {
        return getDriver().findElement(shortPasswordErrorMessage).isDisplayed();
    }

    public boolean isPasswordsMustMatchErrorMessagePresent() {
        return getDriver().findElement(passwordsMustMatchErrorMessage).isDisplayed();
    }

    public void changeName(String name) {
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(firstName)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        getDriver().findElement(firstName).sendKeys(name);
    }

    public void changeLastName(String surname) {
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(lastName)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build().perform();
        getDriver().findElement(lastName).sendKeys(surname);
    }

    public void fillInPasswordsFields(String password1, String password2) {
        getDriver().findElement(password).sendKeys(password1);
        getDriver().findElement(newPassword).sendKeys(password2);
    }

    public void shortPassword(String keyWord, String newKeyWord) {
        getDriver().findElement(password).sendKeys(keyWord);
        getDriver().findElement(newPassword).sendKeys(newKeyWord);
    }
}
