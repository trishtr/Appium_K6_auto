package test.lesson_18;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.page_objects.LoginScreen;

public class LoginScreenPOM_02 {

    public static void main(String[] args) {
        // get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            //find and click login btn
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            //fill in the form

            LoginScreen loginScreen = new LoginScreen(driver);
            loginScreen.loginFormComponents().inputUsername("teo@sth.com");
            loginScreen.loginFormComponents().inputPassword("12345678");
            loginScreen.loginFormComponents().clickLogin();

            //Or method chaining:
            /* loginScreen
                        .inputUsername()
                        .inputPassword()
                        .clickLogin();*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
