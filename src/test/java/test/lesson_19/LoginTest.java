package test.lesson_19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try{
            LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCredData.getEmail(), loginCredData.getPassword());
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            appiumDriver.quit();
        }
    }

    @DataProvider
    public LoginCredData[] loginCredData(){

        //build method to convert Json data to Array of object

        //return an array of objects

        LoginCredData loginCredData01 = new LoginCredData("teo@", "1234568");
        LoginCredData loginCredData02 = new LoginCredData("teo@sth.xyz", "1234567");
        LoginCredData loginCredData03 = new LoginCredData("teo@sth.com", "12345678");

        return new LoginCredData[]{loginCredData01, loginCredData02, loginCredData03};




    }

}
