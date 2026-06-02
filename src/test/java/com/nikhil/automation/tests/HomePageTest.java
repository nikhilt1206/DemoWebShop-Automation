package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads(){
        System.out.println(driver.getTitle());
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        System.out.println(driver.getTitle());
    }

}
