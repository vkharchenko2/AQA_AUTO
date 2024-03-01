package lesson_10.task4;

import lesson_10.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComparisonPage {

    private WebElement comparisonHeader =DriverUtil.getDriver().findElement(By.xpath("//h1[@class='page-heading' and contains(text(),'Product Comparison')]"));

    public boolean isPageOpen(){
       return comparisonHeader.isDisplayed();
    }
}
