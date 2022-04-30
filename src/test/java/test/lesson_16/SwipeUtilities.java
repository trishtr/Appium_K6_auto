package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeUtilities {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement formsBtn = driver.findElement(MobileBy.AccessibilityId("Forms"));
            formsBtn.click();

            //wait transitions done before interacting with elements
            //Wait until on form screen renders
            WebDriverWait wait = new WebDriverWait(driver, 10l);
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]")));

            swipeUp(driver, 10);
        } catch (Exception e) {

        } finally {
            driver.quit();
        }


    }

    public static void swipeUp(MobileDriver driver, int yEndPointPer) {
            Dimension dimension = driver.manage().window().getSize();
            int screenHeight = dimension.getHeight();
            int screenWidth = dimension.getWidth();

            int xStartPoint = 50* screenHeight/100;
            int xEndPoint = 50 * screenHeight/100;

            int yStartPoint = 50* screenWidth;
            int yEndPoint = yEndPointPer * screenWidth/100;
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            //TouchAction to swipe up
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    //.press(startPoint)
                    //.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release().perform();

    }

    public static void swipeDown(MobileDriver driver, int yEndPointPer) {
        Dimension dimension = driver.manage().window().getSize();
        int screenHeight = dimension.getHeight();
        int screenWidth = dimension.getWidth();

        int xStartPoint = 50* screenHeight/100;
        int xEndPoint = 50 * screenHeight/100;

        int yStartPoint = 50* screenWidth;
        int yEndPoint = yEndPointPer * screenWidth/100;
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        //TouchAction to swipe up
        TouchAction touchAction = new TouchAction(driver);
        touchAction
                //.press(startPoint)
                //.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .longPress(endPoint)
                .moveTo(startPoint)
                .release().perform();

    }


}
