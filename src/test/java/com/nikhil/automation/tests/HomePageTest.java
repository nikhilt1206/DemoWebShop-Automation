package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.AccountPage;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads(){

        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("nikhilt1206@gmail.com");
        loginPage.enterPassword("Organic30");

        AccountPage accountPage = loginPage.clickLogin();
        Assert.assertTrue(accountPage.isLogoutDisplayed());

        HomePage homePageAfterLogout = accountPage.clickLogout();
        Assert.assertTrue(homePageAfterLogout.isLoginLinkDisplayed());
    }
}
