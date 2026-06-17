package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.ProductPage;
import com.nikhil.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductCanBeAddedToCart(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        Assert.assertEquals(productPage.getCartCountText(), "(1)");
    }
}
