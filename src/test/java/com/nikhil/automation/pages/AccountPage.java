package com.nikhil.automation.pages;

import com.nikhil.automation.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    private By logoutLink = By.className("ico-logout");

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public HeaderComponent getHeader(){
        return new HeaderComponent(driver);
    }

    public boolean isLogoutDisplayed(){
        return isDisplayed(logoutLink);
    }

    public HomePage clickLogout(){
        click(logoutLink);
        return new HomePage(driver);
    }

}
