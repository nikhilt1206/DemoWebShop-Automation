package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.AccountPage;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserLogin(){

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        AccountPage accountPage = loginPage.login("sushant12@gmail.com","password");
        Assert.assertTrue(accountPage.isLogoutDisplayed());
    }

}
