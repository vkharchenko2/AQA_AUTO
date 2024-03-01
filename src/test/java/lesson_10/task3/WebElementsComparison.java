package lesson_10.task3;

import lesson_10.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebElementsComparison {

    private void compare(WebElement a, WebElement b) {
        int aX = a.getLocation().getX();
        int bX = b.getLocation().getX();
        if (aX < bX) {
            System.out.println("a находится левее, чем b");
        } else if (aX > bX) {
            System.out.println("b находится левее, чем a");
        } else {
            System.out.println("элементы находятся друг над другом");
        }

        int aY = a.getLocation().getY();
        int bY = b.getLocation().getY();
        if (aY < bY) {
            System.out.println("b находится выше, чем a");
        } else if (aY > bY) {
            System.out.println("a находится выше, чем b");
        } else {
            System.out.println("элементы находятся на одной высоте");
        }

        int areaA = a.getRect().getWidth() * a.getRect().getHeight();
        int areaB = b.getRect().getWidth() * b.getRect().getHeight();
        if (areaA < areaB) {
            System.out.println("b больше, чем a");
        } else if (areaA > areaB) {
            System.out.println("a больше, чем b");
        } else {
            System.out.println("элементы занимают одинаковую площадь");
        }
    }

    @Test
    public void comparisonTest() {
        DriverUtil.getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
        WebElement a = DriverUtil.getDriver().findElement(By.xpath("//div[@id='p-associated-pages']//span[text() ='Main Page']"));
        WebElement b = DriverUtil.getDriver().findElement(By.xpath("//div[@id='p-associated-pages']//span[text() ='Talk']"));
        compare(a, b);
    }
}
