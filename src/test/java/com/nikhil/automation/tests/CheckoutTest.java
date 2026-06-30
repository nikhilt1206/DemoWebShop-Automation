    package com.nikhil.automation.tests;

    import com.nikhil.automation.base.BaseTest;
    import com.nikhil.automation.pages.AccountPage;
    import com.nikhil.automation.pages.HomePage;
    import com.nikhil.automation.pages.LoginPage;
    import com.nikhil.automation.pages.SearchResultsPage;
    import com.nikhil.automation.utils.ConfigReader;
    import org.testng.annotations.Test;

    public class CheckoutTest extends BaseTest {

        @Test
        public void verifyRegisteredUserCanNavigateToCheckoutPage(){
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickLogin();
            AccountPage accountPage = loginPage.login(ConfigReader.getProperty("email"),
                    ConfigReader.getProperty("password"));
        }
    }
