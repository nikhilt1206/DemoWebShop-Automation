package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private By searchHeader = By.cssSelector(".page-title h1");
    private By productTitle = By.cssSelector(".product-title a");
    private By noResultsMessage = By.className("result") ;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isSearchPageDisplayed(){
        return isDisplayed(searchHeader);
    }

    public boolean isProductDisplayed(){
        return isDisplayed(productTitle);
    }

    public boolean isNoResultMessageDisplayed(){
        return isDisplayed(noResultsMessage);
    }

    public ProductPage clickProduct(){
        click(productTitle);
        return new ProductPage(driver);
    }
}
