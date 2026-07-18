package com.nikhil.automation.pages;

import com.nikhil.automation.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage{

    private By wishlistProductName = By.cssSelector("td.product a");
    private By removeCheckbox = By.name("removefromcart");
    private By updateWishlistButton = By.name("updatecart");
    private By emptyWishlistMessage = By.cssSelector(".wishlist-content");

    public WishlistPage(WebDriver driver){
        super(driver);
    }

    public String getWishlistProductName(){
        return getText(wishlistProductName);
    }

    public void removeProductFromWishlist(){
        click(removeCheckbox);
        click(updateWishlistButton);
    }

    public String getEmptyWishlistMessage(){
        return getText(emptyWishlistMessage);
    }
}
