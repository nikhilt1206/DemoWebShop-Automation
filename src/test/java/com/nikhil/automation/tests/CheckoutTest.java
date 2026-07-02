    package com.nikhil.automation.tests;

    import com.nikhil.automation.base.BaseTest;
    import com.nikhil.automation.components.HeaderComponent;
    import com.nikhil.automation.pages.*;
    import com.nikhil.automation.utils.ConfigReader;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class CheckoutTest extends BaseTest {

        @Test
        public void verifyRegisteredUserCanNavigateToCheckoutPage(){
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickLogin();
            AccountPage accountPage = loginPage.login(ConfigReader.getProperty("email"),
                    ConfigReader.getProperty("password"));
            HeaderComponent headerComponent = accountPage.getHeader();
            SearchResultsPage searchResultsPage = headerComponent.searchProduct("Laptop");
            ProductPage productPage = searchResultsPage.clickProduct();
            productPage.addToCart();
            headerComponent = productPage.getHeader();
            headerComponent.waitForCartCount("(1)");
            CartPage cartPage = headerComponent.clickShoppingCart();
            cartPage.acceptTermsAndConditions();
            cartPage.clickCheckout();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanProceedToShippingAddress(){
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickLogin();
            AccountPage accountPage = loginPage.login(ConfigReader.getProperty("email"),
                    ConfigReader.getProperty("password"));
            HeaderComponent headerComponent = accountPage.getHeader();
            SearchResultsPage searchResultsPage = headerComponent.searchProduct("Laptop");
            ProductPage productPage = searchResultsPage.clickProduct();
            productPage.addToCart();
            headerComponent = productPage.getHeader();
            headerComponent.waitForCartCount("(1)");
            CartPage cartPage = headerComponent.clickShoppingCart();
            cartPage.acceptTermsAndConditions();
            cartPage.clickCheckout();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.clickBillingAddressContinue();
            Assert.assertTrue(checkoutPage.isInStorePickupCheckboxDisplayed());
        }
    }
