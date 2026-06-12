package com.nikhil.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("test-output/screenshots/"+testName+".png");
        try {
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destination.getAbsolutePath();
    }
}
