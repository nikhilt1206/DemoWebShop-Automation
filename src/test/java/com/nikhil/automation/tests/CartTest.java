package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.components.HeaderComponent;
import com.nikhil.automation.pages.CartPage;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.ProductPage;
import com.nikhil.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductCanBeAddedToCart(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent header = productPage.getHeader();
        header.waitForCartCount("(1)");
        Assert.assertEquals(header.getCartCountText(),"(1)");
    }

    @Test
    public void verifyUserCanNavigateToCartPage(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.getHeader().clickShoppingCart();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }
}
