package test.lesson_20;

import com.google.gson.Gson;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;

public class TestGSON {

    public static void main(String[] args) {

        String filePath = "/src/test/java/test_data/DataObjectBuilder.java";

        LoginCredData[] convertedFromJson = DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);

        for(LoginCredData credData : convertedFromJson)
        {
            System.out.println(credData);
        }

    }
}
