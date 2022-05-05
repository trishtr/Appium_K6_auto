package test.lesson_20;

import com.google.gson.Gson;
import test_data.models.LoginCredData;

public class TestGSON {

    public static void main(String[] args) {
        //covert from object to json

        LoginCredData loginCredData = new LoginCredData("abc", "123");
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCredData));

        String loginCredJSONData = "{\n" +
                "    \"email\": \"abc\",\n" +
                "    \"password\": \"123\"\n" +
                "  }";
        LoginCredData convertedFromJson = gson.fromJson(loginCredJSONData, LoginCredData.class);
        System.out.println(convertedFromJson);
    }
}
