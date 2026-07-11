package com.nikhil.automation.components;

import com.nikhil.automation.pages.BasePage;
import com.nikhil.automation.pages.CartPage;
import com.nikhil.automation.pages.SearchResultsPage;
import com.nikhil.automation.pages.WishlistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {

    private By searchInputBox = By.id("small-searchterms");
    private By searchButton = By.className("search-box-button");
    private By cartQuantity = By.className("cart-qty");
    private By shoppingCartLink = By.className("ico-cart");
    private By wishlistLink = By.cssSelector("a.ico-wishlist");
    private By wishlistCount = By.cssSelector("span.wishlist-qty");

    public HeaderComponent(WebDriver driver){
        super(driver);
    }

    public int getCartCount(){
        String cartCount = getText(cartQuantity);
        String count = cartCount.substring(1,cartCount.length()-1);
        int currentCartCount = Integer.parseInt(count);
        return currentCartCount;
    }

    public void waitForCartCount(int expectedCount){
        String expectedCountText = "(" + expectedCount + ")";
        waitForTextToBePresent(cartQuantity,expectedCountText);
    }

    public CartPage clickShoppingCart(){
        click(shoppingCartLink);
        return new CartPage(driver);
    }

    public SearchResultsPage searchProduct(String product){
        enterDetails(searchInputBox,product);
        click(searchButton);
        return new SearchResultsPage(driver);
    }

    public WishlistPage clickWishlist(){
        click(wishlistLink);
        return new WishlistPage(driver);
    }

    public void waitForWishlistCount(String expectedCount){
        waitForTextToBePresent(wishlistCount,expectedCount);
    }

    public String getWishlistCountText(){
        return getText(wishlistCount);
    }
}
