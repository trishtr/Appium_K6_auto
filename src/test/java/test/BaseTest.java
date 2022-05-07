package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.apache.commons.io.FileUtils.copyFile;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest (description = "Init appium session")
    public void initAppiumSession(){
        appiumDriver = DriverFactory.getDriver(Platforms.android);
    }

    //if test fail, session has to run until finishing execute
    @AfterTest(alwaysRun = true, description = "Quit the appium session")
    public void quitAppiumSession(){
       appiumDriver.quit();
    }

    @AfterMethod(description = "Capture Screenshot")
    public void captureScreenShot(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE)
        {
            //1.get test method name
            String testMethodName = result.getName();
            //2.get time
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE) ;
            int hr = calendar.get(Calendar.HOUR_OF_DAY) ;
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND) ;

            String  dateTaken = y + "-" + m + "-" + d + "-" + hr + "-" + min + "-" + sec ;

            String fileLocation = System.getProperty("user.dir") + "/screenshots/" +
                    testMethodName + "-" + dateTaken + ".png";

            //4. Save
            File screenshot = appiumDriver.getScreenshotAs(OutputType.FILE);

            try{
                FileUtils.copyFile(screenshot, new File(fileLocation));
                Path screenShotContent = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(screenShotContent);

                Allure.addAttachment(testMethodName + "-" + dateTaken , inputStream);


            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }



}
