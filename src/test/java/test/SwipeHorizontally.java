package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeHorizontally {

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

            MobileElement swipeBtn = driver.findElement(MobileBy.AccessibilityId("Swipe"));
            swipeBtn.click();

            //Get window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth/100;

            int yStartPoint = 50 * screenHeight/100;
            int yEndpoint = 50 * screenHeight/100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndpoint);

            // swipe from right to left 5 times
            for (int i = 0; i < 5; i++) {

                TouchAction touchAction = new TouchAction(driver);
                touchAction
                        .longPress(startPoint)
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
