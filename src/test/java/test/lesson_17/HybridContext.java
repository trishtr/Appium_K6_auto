package test.lesson_17;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import context.Contexts;
import context.WaitMoreThanOneContext;

import java.util.ArrayList;
import java.util.List;

public class HybridContext {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {

            //click webview
            By webviewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webviewNavBtnElem = appiumDriver.findElement(webviewNavBtnSel);
            webviewNavBtnElem.click();

            //Custom Explicitly Wait
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            //get all context names_return set (no duplicated elements)
            /* lamdas appiumDriver.getContextHandles().forEach(context ->{
                System.out.println(context);
            });
            */
            //print all the contexts
            for (String context : appiumDriver.getContextHandles()) {
                System.out.println(context);
            }

            //get context first then switch to web view context
            //inspect webview elements - chrome://inspect
            appiumDriver.context(Contexts.WEB_VIEW);

            //Interact on webview elements
            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();

            //handle list of a
            //create 1 object with constructor and getter to hold text and href of a
            //create arraylist of the above object
            //loop through the arraylist
            //getText and getAttribute to get href

            List<MobileElement> menuItemElemens = appiumDriver.findElementsByCssSelector(".menu__list li a");
            List<MenuItemData> menuItemDataList = new ArrayList<>();
            //Map<String,String> menuItemDataMap = new HashMap<>();

            if (menuItemElemens.isEmpty()) {
                throw new RuntimeException(" There is no list item");
            }
            for (MobileElement menuItemElem : menuItemElemens) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");

                if (itemText.isEmpty()) {
                    menuItemDataList.add(new MenuItemData("Github", itemHref));
                    //menuItemDataMap.put("Github", itemHref);
                }
                else {
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                    //menuItemDataMap.put(itemText, itemHref);

                }
            }

            for (MenuItemData menuItemData : menuItemDataList) {
                System.out.println(menuItemData.getName());
                System.out.println(menuItemData.getHref());

            }

            //switch to native
            appiumDriver.context(Contexts.NATIVE);
            //find and click login btn
            WebDriverWait wait1 = new WebDriverWait(appiumDriver, 10l);
            wait1.until(ExpectedConditions.elementToBeClickable(new MobileBy.ByAccessibilityId("Login")));

            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            //fill in the form

            MobileElement userName = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement password = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            userName.sendKeys("teo@sth.com");
            password.sendKeys("12345678");
            loginBtn.click();


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            appiumDriver.quit();
        }

    }

    public static class MenuItemData {
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }

    }
}
