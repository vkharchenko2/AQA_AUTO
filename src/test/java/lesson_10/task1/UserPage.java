package lesson_10.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lesson_10.utils.DriverUtil;

public class UserPage {
   private WebElement uniqueElement = DriverUtil.getDriver().findElement(By.xpath("//p[@class='mt-3 cursor-pointer hover:underline text-sm']"));

    public boolean isPageOpen(){
        return uniqueElement.isDisplayed();
    }
}
