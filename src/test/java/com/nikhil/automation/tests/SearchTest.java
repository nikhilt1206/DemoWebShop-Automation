package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import com.nikhil.automation.pages.HomePage;
import com.nikhil.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void validSearch(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchProduct("Laptop");
        Assert.assertTrue(searchResultsPage.isProductDisplayed());
    }

    @Test
    public void invalidSearch(){
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchProduct("abc12345");
        Assert.assertTrue(searchResultsPage.isNoResultMessageDisplayed());

    }
}
