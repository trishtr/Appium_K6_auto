package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.page_objects.LoginScreen;

public class BaseFlow {
    // no change in run time privat final
    private final AppiumDriver<MobileElement> appiumDriver;


    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void gotoLoginScreen(){
        new LoginScreen(appiumDriver).bottomNavComponents().clickLoginIcon();
    }

}
