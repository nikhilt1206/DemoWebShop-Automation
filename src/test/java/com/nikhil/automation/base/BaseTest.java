package com.nikhil.automation.base;

import com.nikhil.automation.constants.BrowserType;
import com.nikhil.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        String url = ConfigReader.getProperty("url");
        String browser = ConfigReader.getProperty("browser");
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        if(browserType == BrowserType.CHROME){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
