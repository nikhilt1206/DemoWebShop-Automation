package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLogoutDisplayed());
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle,"Demo Web Shop");
    }
}
