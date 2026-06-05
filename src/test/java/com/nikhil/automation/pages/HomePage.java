package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private By loginLink = By.linkText("Log in");
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public boolean isLoginLinkDisplayed(){
        return driver.findElement(loginLink).isDisplayed();
    }

}
