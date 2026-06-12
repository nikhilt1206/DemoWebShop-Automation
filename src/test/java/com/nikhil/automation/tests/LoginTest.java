package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.AccountPage;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.LoginPage;
import com.nikhil.automation.utils.ConfigReader;
import com.nikhil.automation.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserLogin(){

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        AccountPage accountPage = loginPage.login
                (ConfigReader.getProperty("email"),
                 ConfigReader.getProperty("password")
                );
        ScreenshotUtils.captureScreenshot(driver,"LoginTest");
        Assert.assertTrue(accountPage.isLogoutDisplayed());
    }

}
