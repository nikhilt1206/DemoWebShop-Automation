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
        Assert.assertEquals(header.getCartCount(),1);
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
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.acceptTermsAndConditions();
        cartPage.clickCheckout();
        LoginPage loginPage =  new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    public void verifyUserCanRemoveProductFromCart(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.removeProductFromCart();
        Assert.assertEquals(headerComponent.getCartCount(), "(0)");
        Assert.assertEquals(cartPage.getEmptyCartMessage(),"Your Shopping Cart is empty!");
    }

    @Test
    public void verifyUserCanUpdateProductQuantity(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.updateQuantity("3");
        Assert.assertEquals(cartPage.getQuantity(),"3");
    }

    @Test
    public void verifyInvalidCouponDisplaysErrorMessage(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.applyCoupon("INVALID123");
        Assert.assertEquals(cartPage.getCouponErrorMessage(),
                "The coupon code you entered couldn't be applied to your order");
    }

    @Test
    public void verifyInvalidGiftCardDisplaysErrorMessage(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        CartPage cartPage = headerComponent.clickShoppingCart();
        cartPage.applyGiftCard("INVALID12345");
        Assert.assertEquals(cartPage.getGiftCardErrorMessage(),
                "The coupon code you entered couldn't be applied to your order");
    }

    @Test
    public void verifyUserCanContinueShopping(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
        ProductPage productPage = searchResultsPage.clickProduct();
        productPage.addToCart();
        HeaderComponent headerComponent = productPage.getHeader();
        CartPage cartPage = headerComponent.clickShoppingCart();
        searchResultsPage= cartPage.clickContinueShopping();
        Assert.assertTrue(searchResultsPage.isSearchPageDisplayed());
    }
}
