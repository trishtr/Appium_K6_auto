package test.lesson_20;

import org.testng.annotations.*;

public class TestNGHook01 {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite _02");
    }

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
        System.out.println("Before class");
    }
    @Test
    public void testA(){
        System.out.println("test A");
    }
    @Test
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
