package models.page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageObjectFactory {

    private final AppiumDriver<MobileElement> appiumDriver;

    public PageObjectFactory(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        //init element using PageFactory
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }
    @AndroidFindBy(accessibility = "input-email")
    @iOSXCUITFindBy(iOSNsPredicate = "")
    private MobileElement usernameElem;

    @AndroidFindBy(accessibility = "input-password")
    private MobileElement passwordElem;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private MobileElement loginBtnElem;

    public void inputUsername(String username){
        if (!username.isEmpty()){
            usernameElem.sendKeys(username);
        }
    }

    public void inputPassword(String username){
        if (!username.isEmpty()){
            usernameElem.sendKeys(username);
        }
    }

    public void clickLoginBtn(String username){
        if (!username.isEmpty()){
            usernameElem.sendKeys(username);
        }
    }

}
