package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponents {
    private final AppiumDriver<MobileElement> driver;

    private final static By userNameSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailTxtSel =
            MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPasswordTxtSel =
            MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By loginSuccessTxtSel =
            MobileBy.xpath("//*[contains(@text, 'You are logged in!')]");
    private final static By okBtnSel = MobileBy.id("android:id/button1");

    public LoginFormComponents(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement userNameElem() {
        return driver.findElement(userNameSel);
    }

    public MobileElement passwordElem() {
        return driver.findElement(passwordSel);
    }

    public MobileElement loginBtnElem() {
        return driver.findElement(loginBtnSel);
    }


    public void inputUsername(String username) {
        if(!username.isEmpty()){
            userNameElem().sendKeys(username);
        }
    }

    public String getInvalidEmailStr(){
        return driver.findElement(incorrectEmailTxtSel).getText().trim();
    }

    public String getInvalidPasswordStr(){
        return driver.findElement(incorrectPasswordTxtSel).getText().trim();
    }

    public void clickOkBtn(){ driver.findElement(okBtnSel).click();}


    public String getSuccessMessage(){
        return driver.findElement(loginSuccessTxtSel).getText().trim();
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
