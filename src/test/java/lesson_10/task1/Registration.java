package lesson_10.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import lesson_10.utils.DriverUtil;

public class Registration {
   private WebElement firstName = DriverUtil.getDriver().findElement(By.xpath("//input[@placeholder='Fitst Name']"));
  private WebElement lastName = DriverUtil.getDriver().findElement(By.xpath("//input[@placeholder ='Last Name']"));
   private WebElement dateOfBirth = DriverUtil.getDriver().findElement(By.xpath("//input[@placeholder='Date of birth']"));
   private WebElement emailAddress = DriverUtil.getDriver().findElement(By.xpath("//input[@placeholder='Enter email']"));
   private WebElement parole = DriverUtil.getDriver().findElement(By.xpath("//input[@placeholder='Enter password']"));
   private WebElement confirmParole= DriverUtil.getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']"));
   private WebElement submitBtn= DriverUtil.getDriver().findElement(By.xpath("//button[@class='mt-7 h-10 bg-[#feda00] rounded-3xl w-full']"));

    public boolean isPageOpen(){
        return submitBtn.isDisplayed();
    }

    public void enterKeyWords(String enterFirstName,String enterLastName,String enterDateOfBirth, String enterEmail,String enterParole,String enterConfirmParole){
    firstName.sendKeys(enterFirstName);
    lastName.sendKeys(enterLastName);
    dateOfBirth.sendKeys(enterDateOfBirth);
    dateOfBirth.sendKeys(Keys.ENTER);
    emailAddress.sendKeys(enterEmail);
    parole.sendKeys(enterParole);
    confirmParole.sendKeys(enterConfirmParole);
    }

    public void clickOnSubmitBtn(){
        submitBtn.click();
    }
}
