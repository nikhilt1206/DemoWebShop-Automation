package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.components.HeaderComponent;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.ProductPage;
import com.nikhil.automation.pages.SearchResultsPage;
import com.nikhil.automation.pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    @Test
    public void verifyUserCanAddProductToWishlist() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Smartphone");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToWishlist();
        HeaderComponent headerComponent = productPage.getHeader();
        headerComponent.waitForWishlistCount("(1)");
        Assert.assertEquals(headerComponent.getWishlistCountText(),"(1)");
        WishlistPage wishlistPage = headerComponent.clickWishlist();
        Assert.assertEquals(wishlistPage.getWishlistProductName(),"Smartphone");
    }

}
