package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private By productTitle = By.className("product-title");
    private By noResultsMessage = By.className("result") ;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isProductDisplayed(){
        return isDisplayed(productTitle);
    }

    public boolean isNoResultMessageDisplayed(){
        return isDisplayed(noResultsMessage);
    }

    public ProductPage clickProduct(){
        click(productTitle);
        System.out.println(driver.getCurrentUrl());
        return new ProductPage(driver);
    }
}
