package com.nikhil.automation.utils;
import com.google.gson.Gson;
import com.nikhil.automation.pojo.LoginData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public final class JsonUtils {
    public static LoginData getLoginData(){
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(System.getProperty("user.dir")
                    + "/src/test/resources/testData/loginData.json");
            return gson.fromJson(fileReader,LoginData.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
