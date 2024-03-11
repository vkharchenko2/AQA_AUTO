package lesson_13;

import org.openqa.selenium.By;
import static driverUtil.DriverUtil.*;

public class UserPage {

    private By editAccBtn =By.xpath("//a[text()='Edit account']");
    private By nameText =By.xpath("//div/p[text()='First name']/following::p[1]");
    private By lastNameText =By.xpath("//div/p[text()='Last name']/following::p[1]");

    public String getUserName(){
      return getDriver().findElement(nameText).getText();
    }

    public String getUserLastName(){
      return getDriver().findElement(lastNameText).getText();
    }

    public boolean isEditAccBtnDisplayed(){
        return getDriver().findElement(editAccBtn).isDisplayed();
    }

    public void clickOnEditAcc(){
        getDriver().findElement(editAccBtn).click();
    }
}
