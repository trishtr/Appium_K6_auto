package test.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

import static io.appium.java_client.MobileBy.AccessibilityId;

public class XPATHLearning {

     public static void main(String[] args) {

          AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

          try{
               MobileElement navLoginElement = driver.findElement(MobileBy.AccessibilityId("Login"));
               navLoginElement.click();

               //list of all matching elements
               List<MobileElement> editTextElements = driver.findElements(MobileBy.xpath("//android.widget.EditText"));
               final int USER_NAME_INDEX = 0;
               final int PASSWORD_INDEX = 1;
               editTextElements.get(USER_NAME_INDEX).sendKeys("teo@sth.com");
               editTextElements.get(PASSWORD_INDEX).sendKeys("12345678");

               MobileElement loginInstruction =
                       driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));

               System.out.println("Login Instruction: " + loginInstruction.getText());

          }
          catch(Exception e){
               e.printStackTrace();
          }
          finally {
               driver.quit();
          }

     }
}
