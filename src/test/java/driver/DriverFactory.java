package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static driver.MobileCapacityTypeEx.APP_ACTIVITY;
import static driver.MobileCapacityTypeEx.APP_PACKAGE;
import static driver.Platforms.android;
import static driver.Platforms.ios;

public class DriverFactory implements MobileCapabilityType {

    public static AppiumDriver<MobileElement> getDriver(Platforms platform) {
        if (platform == null) {
            throw new IllegalArgumentException("Platform can't be null, you can provide one of these: "
                    + Arrays.toString(Platforms.values()));
        }

        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;
        try {
            //Desired Capabilities
            DesiredCapabilities desiredCaps = new DesiredCapabilities();
            desiredCaps.setCapability(PLATFORM_NAME, "Android");
            desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCaps.setCapability(UDID, "HT76T0201417");
            desiredCaps.setCapability(APP_PACKAGE, "com.wdiodemoapp");
            desiredCaps.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");

            //init Appium session
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            switch(platform){
                case android:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCaps);
                    break;

                case ios:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
            }



        } catch (Exception e) {
            exception = e;
        }

        if (appiumDriver == null) {
            throw new RuntimeException(exception.getMessage());
        }

        //add implicitly wait
        appiumDriver.manage().timeouts().implicitlyWait(5l, TimeUnit.SECONDS);
        return appiumDriver;
        }

}