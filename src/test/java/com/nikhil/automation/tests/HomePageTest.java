package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.AccountPage;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.LoginPage;
import com.nikhil.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads(){

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickLogin();
//        loginPage.enterEmail(ConfigReader.getProperty("email"));
//        loginPage.enterPassword(ConfigReader.getProperty("password"));

        AccountPage accountPage = loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );
        Assert.assertTrue(accountPage.isLogoutDisplayed());

        HomePage homePageAfterLogout = accountPage.clickLogout();
        Assert.assertTrue(homePageAfterLogout.isLoginLinkDisplayed());
    }
}
