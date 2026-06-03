package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Password");
    private By loginButton = By.cssSelector(".login-button");
    private By logoutLink = By.className("ico-logout");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailTextBox).sendKeys(email);
    }
    public void enterPassword(String password){
        driver.findElement(passwordTextBox).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public boolean isLogoutDisplayed(){
        return driver.findElement(logoutLink).isDisplayed();
    }
}
