package test.context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitMoreThanOneContext implements ExpectedCondition<Boolean> {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WaitMoreThanOneContext(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver = appiumDriver;
    }

    //override apply method in ExpectedCondition Interface
    @Override
    public Boolean apply(WebDriver input) {
        return appiumDriver.getContextHandles().size() > 1;
    }
}
