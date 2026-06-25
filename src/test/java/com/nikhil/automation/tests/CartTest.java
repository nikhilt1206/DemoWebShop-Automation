package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.components.HeaderComponent;
import com.nikhil.automation.pages.*;
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

    @Test
    public void verifyAddedProductIsDisplayedInCart(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        headerComponent.waitForCartCount("(1)");
        CartPage cartPage = headerComponent.clickShoppingCart();
        Assert.assertEquals(cartPage.getProductName(),"14.1-inch Laptop");
    }

    @Test
    public void verifyGuestUserCanProceedToCheckout(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        headerComponent.waitForCartCount("(1)");
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.acceptTermsAndConditions();
        LoginPage loginPage = cartPage.clickCheckout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    public void verifyUserCanRemoveProductFromCart(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        headerComponent.waitForCartCount("(1)");
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.removeProductFromCart();
        headerComponent.waitForCartCount("(0)");
        Assert.assertEquals(headerComponent.getCartCountText(), "(0)");
        Assert.assertEquals(cartPage.getEmptyCartMessage(),"Your Shopping Cart is empty!");
    }
}
