package test_flows.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_flows.BaseFlow;

public class FormFlow extends BaseFlow {
    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }


    public void fillTheForm(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10l);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]")));


        //Get window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
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
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction
                //.press(startPoint)
                //.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .longPress(startPoint)
                .moveTo(endPoint)
                .release().perform();

    }
    public void verifyFormDisplay(){

    }
}
