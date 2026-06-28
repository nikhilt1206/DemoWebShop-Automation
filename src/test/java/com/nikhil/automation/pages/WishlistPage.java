package com.nikhil.automation.pages;

import com.nikhil.automation.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage{

    private By wishlistProductName = By.cssSelector("td.product a");

    public WishlistPage(WebDriver driver){
        super(driver);
    }

    public HeaderComponent getHeader(){
        return new HeaderComponent(driver);
    }

    public String getWishlistProductName(){
        return getText(wishlistProductName);
    }
}
