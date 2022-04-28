package test.lesson_18;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.BottomNavComponents;
import models.components.LoginFormComponents;
import models.page_objects.LoginScreen;

public class LoginScreenPOM_03 {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            //find and click login btn
            LoginScreen loginScreen = new LoginScreen(driver);
            BottomNavComponents bottomNavComponents = loginScreen.bottomNavComponents();
            LoginFormComponents loginFormComponents = loginScreen.loginFormComponents();

            bottomNavComponents.clickLoginIcon();
            //fill in the form

            loginFormComponents.inputUsername("teo@sth.com");
            loginFormComponents.inputPassword("12345678");
            loginFormComponents.clickLogin();

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
