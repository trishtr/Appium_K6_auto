package test.lesson_18;

import driver.AppPackages;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.BottomNavComponents;
import models.components.LoginFormComponents;
import models.page_objects.LoginScreen;
import org.openqa.selenium.By;

import java.time.Duration;

public class HandleMultipleApps {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try{
            //Login > input credentials > Loginbtn


            LoginScreen loginScreen = new LoginScreen(driver);
            //LoginFormComponents loginFormComponents = loginScreen.loginFormComponents();
            //BottomNavComponents bottomNavComponents = loginScreen.bottomNavComponents();

            loginScreen.bottomNavComponents().clickLoginIcon();

            loginScreen.loginFormComponents().inputUsername("teo@sth.com");
            loginScreen.loginFormComponents().inputPassword("12345678");
            loginScreen.loginFormComponents().clickLogin();

            //Put the app into background > Home btn/////important ****** .runAppInBackground(Duration.ofSeconds(negative))
            driver.runAppInBackground(Duration.ofSeconds(-1));

            //Turn wifi off = switch to another apps > .activateApp(AppPackages)
            driver.activateApp(AppPackages.setting);

            MobileElement networkLabelSelector = driver.findElement(MobileBy.xpath("//*[@text='Network & internet']"));
            networkLabelSelector.click();

            MobileElement wifiStatus = driver.findElement(MobileBy.AccessibilityId("Wi‑Fi"));
            wifiStatus.click();

            MobileElement wifiStatusTxt = driver.findElement(MobileBy.id("android:id/summary"));
            String wifiStatusTxt_Str = wifiStatusTxt.getText().trim();
            boolean isWifiOff = wifiStatusTxt_Str.equalsIgnoreCase("Off");
            if(!isWifiOff)
            {
                wifiStatus.click();
            }

            //come back to native apps
            driver.activateApp(AppPackages.wdio);
            driver.findElement(MobileBy.xpath("//*[@text='OK']")).click();



            //*[@text='Network & internet']
            //*[@text = "Wi‑Fi"
            // id = android:id/summary
            //Come back to app and interact with other elements
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }
}
