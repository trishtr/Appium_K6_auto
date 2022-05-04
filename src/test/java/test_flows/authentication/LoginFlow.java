package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.LoginFormComponents;
import models.page_objects.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;

    private String usernameStr;
    private String passwordStr;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver,String usernameStr, String passwordStr) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.usernameStr = usernameStr;
        this.passwordStr = passwordStr;
    }


    public void login(){
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponents loginFormComponents = loginScreen.loginFormComponents();
        if(!usernameStr.isEmpty())
        {   MobileElement emailElem = loginFormComponents.userNameElem();
            emailElem.clear();
            emailElem.sendKeys(usernameStr);
        }
        if(!passwordStr.isEmpty())
        {
            MobileElement passwordElem = loginFormComponents.passwordElem();
            passwordElem.clear();
            passwordElem.sendKeys(passwordStr);
        }
        loginFormComponents.clickLogin();
    }

    public void verifyLogin(){

        //commons-validator apache
        boolean isEmailValid = EmailValidator.getInstance().isValid(usernameStr);
        boolean isPasswordValid = passwordStr.length() >=8 ;

        System.out.printf("Email: %s , %b | Password: %s , %b\n ",
                usernameStr, isEmailValid , passwordStr , isPasswordValid);

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponents loginFormComponents = loginScreen.loginFormComponents();

        if(isEmailValid && isPasswordValid)
        {
            verifyCorrectLoginCreds(loginFormComponents);
        }
        if(!isEmailValid)
        {
            verifyIncorrectEmailStr(loginFormComponents);
        }
        if(!isPasswordValid)
        {
            verifyIncorrectPasswordStr(loginFormComponents);
        }
        System.out.println("\n===============================");
    }
    private void verifyCorrectLoginCreds(LoginFormComponents loginFormComponents) {
        //TODO:

        String successLoginMessageTxt = loginFormComponents.getSuccessMessage();
        System.out.println(successLoginMessageTxt);
        loginFormComponents.clickOkBtn();

    }

    private void verifyIncorrectEmailStr(LoginFormComponents loginFormComponents) {
        String actualInvalidEmailStr  = loginFormComponents.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address";

        System.out.println("actual " + actualInvalidEmailStr);
        System.out.println("expected : " + expectedInvalidEmailStr);
    }

    private void verifyIncorrectPasswordStr(LoginFormComponents loginFormComponents) {
        String actualInvalidPasswordStr  = loginFormComponents.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";

        System.out.println("actual " + actualInvalidPasswordStr);
        System.out.println("expected: " + expectedInvalidPasswordStr);
    }

    //support method

}
