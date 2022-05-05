package test.lesson_20;

import org.testng.annotations.*;

public class TestNGHook02 {
    //testng will execute test following alphabet

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite _02");
    }
    //execute before test tag in xml
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }

    @Test(priority = 2)
    public void testA(){
        System.out.println("test A");
    }
    @Test(priority = 1)
    public void testB(){
        System.out.println("test B");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite _02");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after Test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @BeforeMethod
    public void afterMethod(){
        System.out.println("after class");
    }
}
