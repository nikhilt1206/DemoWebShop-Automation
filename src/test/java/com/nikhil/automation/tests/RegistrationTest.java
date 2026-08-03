package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.RegisterPage;
import com.nikhil.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyUserRegistration(){
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.clickRegister();

        String email = "nikhil" + System.currentTimeMillis() + "@gmail.com";

        registerPage.registerUser(
                registrationData.getGender(),
                registrationData.getFirstName(),
                registrationData.getLastName(),
                email,
                registrationData.getPassword()
        );
        Assert.assertEquals(registerPage.getRegistrationSuccessMessage(),"Your registration completed");
    }
}
