package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.AccountPage;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.nikhil.automation.listeners.TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void verifyUserLogin(){

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        AccountPage accountPage = loginPage.login(
                loginData.getEmail(),
                loginData.getPassword()
        );
        //ScreenshotUtils.captureScreenshot(driver,"LoginTest");
        Assert.assertTrue(accountPage.isLogoutDisplayed());
        //Assert.assertTrue(false);
    }
}
