package models.page_objects;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.BottomNavComponents;
import models.components.LoginFormComponents;
import org.openqa.selenium.By;

public class LoginScreen {
    private final AppiumDriver<MobileElement> driver;
    //public LoginFormComponents loginFormComponents;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public LoginFormComponents loginFormComponents(){
        return new LoginFormComponents(driver);
    }
    //add all BottomNav Comp inside Login Pages
    public BottomNavComponents bottomNavComponents() {
        return new BottomNavComponents(driver);
    }
}
