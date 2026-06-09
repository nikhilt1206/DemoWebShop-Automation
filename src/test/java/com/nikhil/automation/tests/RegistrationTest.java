package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyUserRegistration(){
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.clickRegister();

        String email = "nikhil" + System.currentTimeMillis() + "@gmail.com";

        registerPage.selectGender("male");
        registerPage.enterFirstName("Nikhil");
        registerPage.enterLastName("Sharma");
        registerPage.enterEmail(email);
        registerPage.enterPassword("organic40");
        registerPage.enterConfirmPassword("organic40");
        registerPage.clickRegister();

        String actualMessage = registerPage.getRegistrationSuccessMessage();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
