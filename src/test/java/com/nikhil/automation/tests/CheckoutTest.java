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

        @Test
        public void verifyRegisteredUserCanProceedToShippingMethod(){
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
            checkoutPage.clickShippingAddressContinue();
            Assert.assertTrue(checkoutPage.isGroundShippingMethodDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanProceedToPaymentMethod(){
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
            checkoutPage.clickShippingAddressContinue();
            checkoutPage.clickShippingMethodContinue();
            Assert.assertTrue(checkoutPage.isCashOnDeliveryDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanPlaceOrderSuccessfully(){
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
            checkoutPage.clickShippingAddressContinue();
            checkoutPage.clickShippingMethodContinue();
            checkoutPage.clickPaymentMethodContinue();
            checkoutPage.clickPaymentInformationContinue();
            checkoutPage.clickConfirmOrderContinue();
            Assert.assertTrue(checkoutPage.isOrderConfirmSuccessMessageDisplayed());
        }

        @Test
        public void verifyCheckoutAsGuest(){
            HomePage homePage = new HomePage(driver);
            SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
            ProductPage productPage = searchResultsPage.clickProduct();
            productPage.addToCart();
            HeaderComponent headerComponent = productPage.getHeader();
            headerComponent.waitForCartCount("(1)");
            CartPage cartPage = headerComponent.clickShoppingCart();
            cartPage.acceptTermsAndConditions();
            LoginPage loginPage = cartPage.clickCheckout();
            loginPage.clickCheckoutAsGuest();
        }
    }
