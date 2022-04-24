package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.util.List;

public class lab16_1 {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try{
            MobileElement formBtn = driver.findElement(MobileBy.AccessibilityId("Forms"));
            formBtn.click();

            MobileElement inputField = driver.findElement(MobileBy.AccessibilityId("text-input"));
            inputField.sendKeys("testing with appium");

            MobileElement inputTextResult = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            System.out.println(inputTextResult);

            MobileElement switchBtn = driver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement switchText = driver.findElement(MobileBy.AccessibilityId("switch-text"));
            System.out.println("Before clicking switch Btn : " + switchText.getText() );
            switchBtn.click();
            System.out.println("After click switch Btn: " + switchText.getText());

            MobileElement iconDropdown = driver.findElement(MobileBy.AccessibilityId("Dropdown"));
            iconDropdown.click();


            List<MobileElement> dropdownOptions = driver.findElements(MobileBy.id("android:id/text1"));
            dropdownOptions.get(1).click();
            MobileElement dropdownText_1 = driver.findElement(MobileBy.className("android.widget.EditText"));
            System.out.println("dropdown option 1: " + dropdownText_1.getText());

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


            MobileElement activeBtn = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtn.click();
            MobileElement askMeLaterBtn = driver.findElement(MobileBy.id("android:id/button3"));
            MobileElement cancelBtn = driver.findElement(MobileBy.id("android:id/button2"));
            MobileElement okBtn = driver.findElement(MobileBy.id("android:id/button1"));
            okBtn.click();


        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            driver.quit();
        }
    }
}
