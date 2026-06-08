package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By loginLink = By.linkText("Log in");
    private By registerLink = By.linkText("Register");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public LoginPage clickLogin(){
        click(loginLink);
        return new LoginPage(driver);
    }

    public boolean isLoginLinkDisplayed(){
        return isDisplayed(loginLink);
    }

    public RegisterPage clickRegister(){
        click(registerLink);
        return new RegisterPage(driver);
    }

}
