package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {

    public static void main(String[] args) {
        // get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
    try {
        //find and click login btn
        MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
        navLoginBtnElem.click();
        //fill in the form

        MobileElement userName = driver.findElement(MobileBy.AccessibilityId("input-email"));
        MobileElement password = driver.findElement(MobileBy.AccessibilityId("input-password"));
        MobileElement loginBtn = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

        userName.sendKeys("teo@sth.com");
        password.sendKeys("12345678");
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5L);

        //Get tag from login dialog
        //times out exceptions
        //no such elements exceptions
        WebElement loginDialogTitle = wait.until(ExpectedConditions.visibilityOfElementLocated
                (MobileBy.id("android:id/alertTitle")));

        System.out.println("Title: " + loginDialogTitle.getText());

    } catch(Exception e){
        e.printStackTrace();
    } finally {
        driver.quit();
    }
        //quit appium session

    }
}
