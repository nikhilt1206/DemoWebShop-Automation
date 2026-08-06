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
    public void verifyValidUserLogin(){

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(
                loginData.getEmail(),
                loginData.getPassword()
        );
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isLogoutDisplayed());
    }

    @Test
    public void verifyInvalidUserLogin(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(
                invalidLoginData.getEmail(),
                invalidLoginData.getPassword()
        );
        Assert.assertTrue(
                loginPage.getLoginErrorMessage()
                        .contains("Login was unsuccessful")
        );
    }
}
