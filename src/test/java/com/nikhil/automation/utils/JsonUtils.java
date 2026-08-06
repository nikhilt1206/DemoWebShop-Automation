package com.nikhil.automation.utils;
import com.google.gson.Gson;
import com.nikhil.automation.pojo.LoginData;
import com.nikhil.automation.pojo.RegistrationData;

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

    public static LoginData getInvalidLoginData() {
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(
                    System.getProperty("user.dir")
                            + "/src/test/resources/testData/invalidLoginData.json");
            return gson.fromJson(fileReader, LoginData.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static RegistrationData getRegistrationData(){
        Gson gson = new Gson();
        try{
            FileReader fileReader = new FileReader(System.getProperty("user.dir")
                    + "/src/test/resources/testData/registrationData.json");;
            return gson.fromJson(fileReader,RegistrationData.class);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
