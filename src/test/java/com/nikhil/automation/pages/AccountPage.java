package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver;
    private By logoutLink = By.className("ico-logout");

    public AccountPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean isLogoutDisplayed(){
        return driver.findElement(logoutLink).isDisplayed();
    }

    public HomePage clickLogout(){
        driver.findElement(logoutLink).click();
        return new HomePage(driver);
    }

}
