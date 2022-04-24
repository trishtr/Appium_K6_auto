package test.lesson_17;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TakingScreenshot {

    public static void main(String[] args) {

        //add one more dependency : common-io
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try{

            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            //Whole screen
            File base64SscreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshot/").concat("HomeScreen.png");
            FileUtils.copyFile(base64SscreenshotData, new File(fileLocation));

            //an Area - Login screen
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64loginFormElemData = loginFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormLocation = System.getProperty("user.dir").concat("/screenshot/").concat("LoginForm.png");
            FileUtils.copyFile(base64loginFormElemData, new File(loginFormLocation));

            //an area - Login Btn
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64loginBtnElemData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            String loginBtnElemLocation = System.getProperty("user.dir").concat("/screenshot/").concat("LoginBtn.png");
            FileUtils.copyFile(base64loginBtnElemData, new File(loginBtnElemLocation));


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            appiumDriver.quit();
        }

    }
}

