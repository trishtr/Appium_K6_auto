package test.lesson_20;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviderExploring {

    @Test(dataProvider = "getDataSet")
    public void testSth(String text){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        softAssert.assertFalse(true);
        System.out.println(text);
        softAssert.assertAll();

    }

    //first priority : find dataProvider
    //if not, then will find @DataProvider

    @DataProvider(name = "getDataSet")
    public String[] getDataSet(){
        return new String[] {"txt1", "txt2", "txt3"};
    }
}
