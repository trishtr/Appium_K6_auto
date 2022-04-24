package test.lesson_16;

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

public class SwipeVertically {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try{
            MobileElement formsBtn = driver.findElement(MobileBy.AccessibilityId("Forms"));
            formsBtn.click();

            //wait transitions done before interacting with elements
            //Wait until on form screen renders
            WebDriverWait wait = new WebDriverWait(driver, 10l);
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]")));


            //Get window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            //Calculate Touch points (vertically_ xStartPoint & xEndPoint are the same)
            int xStartPoint = 50 * screenWidth/100;
            int xEndPoint = 50 * screenWidth/100;


            //swipe vertically _ yStartPoint = 50%, & yEndPoint will decrease
            int yStartPoint = 50 * screenHeight/100;
            int yEndPoint = 10 * screenHeight/100;

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

            //swipe down
            touchAction
                    //.press(startPoint)
                    //.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release().perform();




            MobileElement activeBtn = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtn.click();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }

    }
}
