package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Password");
    private By loginButton = By.cssSelector(".login-button");


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterEmail(String email){
        enterDetails(emailTextBox,email);
    }
    public void enterPassword(String password){
        enterDetails(passwordTextBox,password);
    }
    public AccountPage clickLogin(){
        click(loginButton);
        return new AccountPage(driver);
    }
    public AccountPage login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        return clickLogin();
    }
}
