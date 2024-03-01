package lesson_10.task2;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import lesson_10.utils.DriverUtil;

import java.util.Set;

public class WebPages {
    String window ="window.open('%s')";
    String zoo = "Zoo";
    String[] webPages = {"http://www.automationpractice.pl/index.php",
            "https://zoo.waw.pl/",
            "https://www.w3schools.com/",
            "https://www.clickspeedtester.com/click-counter/",
            "https://andersenlab.com/"};

    @Test
    public void urls() {
        for (String url : webPages) {
            JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
            js.executeScript(String.format(window, url));
        }
        Set<String> allWindowsHandles = DriverUtil.getDriver().getWindowHandles();
        for (String handle : allWindowsHandles) {
            DriverUtil.getDriver().switchTo().window(handle);
            System.out.println(DriverUtil.getDriver().getCurrentUrl());
            System.out.println(DriverUtil.getDriver().getTitle());
            if(DriverUtil.getDriver().getTitle().contains(zoo)){
                DriverUtil.getDriver().close();
            }
        }
    }
}
