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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try{
            //Get window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            //Calculate Touch points (vertically_ xStartPoint & xEndPoint are the same)
            int xStartPoint = 50 * screenWidth/100;
            int xEndPoint = 50 * screenWidth/100;


            //swipe vertically _ yStartPoint = 50%, & yEndPoint will decrease
            int yStartPoint = 0;
            int yEndPoint = 50 * screenHeight/100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            //TouchAction to swipe up
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .press(startPoint)
                    .moveTo(endPoint)
                    .release().perform();

            //Have to swipe up to dimiss notificatiions

            touchAction
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release().perform();

            Map<String, String> notifications = new HashMap<>();
            List<MobileElement> notificationElements = driver.findElements(MobileBy.id("android:id/notification_main_column"));

            //using parent element to find the child elements inside
            for (MobileElement notificationElement : notificationElements) {
                MobileElement titleElem = notificationElement.findElement(MobileBy.id("android:id/line1"));
                String titleText = titleElem.getText();
                MobileElement contentElem = driver.findElement(MobileBy.id("android:id/text"));
                String contentText = contentElem.getText();

                notifications.put(titleText, contentText);
            }

            if(notifications.keySet().isEmpty()){
                throw new RuntimeException("There is no notification to test");
            }else {
                for(String title : notifications.keySet()){
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + notifications.get(title));
                }
            }



        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }
}
