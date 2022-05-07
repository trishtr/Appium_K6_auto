package models.page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.BottomNavComponents;
import models.components.LoginFormComponents;

public class HomeScreen {

    private final AppiumDriver<MobileElement> driver;
    //public LoginFormComponents loginFormComponents;

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public BottomNavComponents bottomNavComponents() {
        return new BottomNavComponents(driver);
    }
}
