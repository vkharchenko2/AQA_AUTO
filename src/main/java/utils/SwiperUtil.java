package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwiperUtil {

    public SwiperUtil(AppiumDriver driver) {
        this.driver = driver;
    }

    public AppiumDriver driver;

    public void swipe(int startX, int startY, int finalX, int finalY) {
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(finalX, finalY))
                .release().perform();
    }

    public enum Directions {
        UP, DOWN
    }

    public void swipe(Directions directions) {
        int startX = 0;
        int startY = 0;
        int finishX = 0;
        int finishY = 0;
        Dimension screenSize = driver.manage().window().getSize();
        switch (directions) {
            case DOWN:
                startX = screenSize.width / 2;
                startY = (int) (screenSize.height * 0.2);
                finishX = screenSize.width / 2;
                finishY = (int) (screenSize.height * 0.8);
                break;
            case UP:
                startX = screenSize.width / 2;
                startY = (int) (screenSize.height * 0.8);
                finishX = screenSize.width / 2;
                finishY = (int) (screenSize.height * 0.2);
                break;
        }
        swipe(startX, startY, finishX, finishY);
    }
}
