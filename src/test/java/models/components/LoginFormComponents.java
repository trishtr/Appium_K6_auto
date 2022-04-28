package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponents {
    private final AppiumDriver<MobileElement> driver;

    private final static By userNameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponents(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private MobileElement userNameElem() {
        return driver.findElement(userNameSel);
    }

    private MobileElement passwordElem() {
        return driver.findElement(passwordSel);
    }

    private MobileElement loginBtnElem() {
        return driver.findElement(loginBtnSel);
    }

    public void inputUsername(String username) {
        if(!username.isEmpty()){
            userNameElem().sendKeys(username);
        }
    }

    public void inputPassword(String password) {
        if(!password.isEmpty()){
            passwordElem().sendKeys(password);
        }
    }

    public void clickLogin() {
            loginBtnElem().click();

    }



}
