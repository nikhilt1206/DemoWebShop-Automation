package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    private By logoutLink = By.className("ico-logout");

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public boolean isLogoutDisplayed(){
        return isDisplayed(logoutLink);
    }

    public HomePage clickLogout(){
        click(logoutLink);
        return new HomePage(driver);
    }

}
