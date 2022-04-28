package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavComponents {

    private final AppiumDriver<MobileElement> driver;

    private final static By homeIconSel = MobileBy.AccessibilityId("Home");
    private final static By webIconSel = MobileBy.AccessibilityId("Webview");
    private final static By loginIconSel = MobileBy.AccessibilityId("Login");
    private final static By formIconSel = MobileBy.AccessibilityId("Forms");
    private final static By swipeIconSel = MobileBy.AccessibilityId("Swipe");
    private final static By dragIconSel = MobileBy.AccessibilityId("Drag");


    public BottomNavComponents(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickHomeIcon(){
        driver.findElement(homeIconSel).click();
    }

    public void clickWebIcon(){
        driver.findElement(webIconSel).click();
    }

    public void clickLoginIcon(){
        driver.findElement(loginIconSel).click();
    }

    public void clickFormsIcon(){
        driver.findElement(formIconSel).click();
    }

    public void clickDragIcon(){
        driver.findElement(dragIconSel).click();
    }

    public void clickSwipeIcon(){
        driver.findElement(swipeIconSel).click();
    }
}
