    package com.nikhil.automation.tests;

    import com.nikhil.automation.base.BaseTest;
    import com.nikhil.automation.components.HeaderComponent;
    import com.nikhil.automation.pages.*;
    import com.nikhil.automation.pojo.BillingAddress;
    import com.nikhil.automation.utils.ConfigReader;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class CheckoutTest extends BaseTest {

            private CheckoutPage navigateToRegisteredCheckout(){
                HomePage homePage = new HomePage(driver);
                LoginPage loginPage = homePage.clickLogin();
                AccountPage accountPage = loginPage.login(ConfigReader.getProperty("email"),
                        ConfigReader.getProperty("password"));
                HeaderComponent headerComponent = accountPage.getHeader();
                SearchResultsPage searchResultsPage = headerComponent.searchProduct("Laptop");
                ProductPage productPage = searchResultsPage.clickProduct();
                productPage.addToCart();
                headerComponent = productPage.getHeader();
                CartPage cartPage = headerComponent.clickShoppingCart();
                cartPage.acceptTermsAndConditions();
                cartPage.clickCheckout();
                return new CheckoutPage(driver);
            }

            private CheckoutPage navigateToGuestCheckout(){
                HomePage homePage = new HomePage(driver);
                SearchResultsPage searchResultsPage = homePage.getHeader().searchProduct("Laptop");
                ProductPage productPage = searchResultsPage.clickProduct();
                productPage.addToCart();
                HeaderComponent headerComponent = productPage.getHeader();
                CartPage cartPage = headerComponent.clickShoppingCart();
                cartPage.acceptTermsAndConditions();
                LoginPage loginPage = cartPage.clickCheckout();
                CheckoutPage checkoutPage = loginPage.clickCheckoutAsGuest();
                BillingAddress billingAddress = new BillingAddress(
                        "Nikhil",
                        "Tiwari",
                        "nikhil@test.com",
                        "India",
                        "Varanasi",
                        "Bhelupura",
                        "221001",
                        "9876543210"
                );
                checkoutPage.fillBillingAddress(billingAddress);
                return checkoutPage;
            }

        @Test
        public void verifyRegisteredUserCanNavigateToCheckoutPage(){
            CheckoutPage checkoutPage = navigateToRegisteredCheckout();
            Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanProceedToShippingAddress(){
            CheckoutPage checkoutPage = navigateToRegisteredCheckout();
            checkoutPage.clickBillingAddressContinue();
            Assert.assertTrue(checkoutPage.isInStorePickupCheckboxDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanProceedToShippingMethod(){
            CheckoutPage checkoutPage = navigateToRegisteredCheckout();
            checkoutPage.clickBillingAddressContinue();
            checkoutPage.clickShippingAddressContinue();
            Assert.assertTrue(checkoutPage.isGroundShippingMethodDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanProceedToPaymentMethod(){
            CheckoutPage checkoutPage = navigateToRegisteredCheckout();
            checkoutPage.clickBillingAddressContinue();
            checkoutPage.clickShippingAddressContinue();
            checkoutPage.clickShippingMethodContinue();
            Assert.assertTrue(checkoutPage.isCashOnDeliveryDisplayed());
        }

        @Test
        public void verifyRegisteredUserCanPlaceOrderSuccessfully(){
            CheckoutPage checkoutPage = navigateToRegisteredCheckout();
            checkoutPage.clickBillingAddressContinue();
            checkoutPage.clickShippingAddressContinue();
            checkoutPage.clickShippingMethodContinue();
            checkoutPage.clickPaymentMethodContinue();
            checkoutPage.clickPaymentInformationContinue();
            OrderConfirmationPage orderConfirmationPage = checkoutPage.clickConfirmOrderContinue();
            String orderNumber = orderConfirmationPage.getOrderNumber();
            Assert.assertFalse(orderNumber.isEmpty());
            AccountPage accountPage = orderConfirmationPage.getHeader().clickMyAccount();
            OrdersPage ordersPage = accountPage.clickOrders();
            OrderDetailsPage orderDetailsPage =  ordersPage.clickOrderDetails(orderNumber);
            Assert.assertEquals(
                    orderDetailsPage.getProductName(),
                    "14.1-inch Laptop"
            );
            Assert.assertTrue(ordersPage.isOrderPresent(orderNumber));
        }

        @Test
        public void verifyGuestUserCanProceedToShippingAddress(){
            CheckoutPage checkoutPage = navigateToGuestCheckout();
            checkoutPage.clickBillingAddressContinue();
            Assert.assertTrue(checkoutPage.isInStorePickupCheckboxDisplayed());
        }

        @Test
        public void verifyGuestUserCanPlaceOrderSuccessfully(){
            CheckoutPage checkoutPage = navigateToGuestCheckout();
            checkoutPage.clickBillingAddressContinue();
            checkoutPage.clickShippingAddressContinue();
            checkoutPage.clickShippingMethodContinue();
            checkoutPage.clickPaymentMethodContinue();
            checkoutPage.clickPaymentInformationContinue();
            OrderConfirmationPage orderConfirmationPage = checkoutPage.clickConfirmOrderContinue();
            Assert.assertTrue(orderConfirmationPage.isOrderPlaced());
            String orderNumber = orderConfirmationPage.getOrderNumber();
            System.out.println("Order Number: "+orderNumber);
            Assert.assertFalse(orderNumber.isEmpty());
        }
    }
