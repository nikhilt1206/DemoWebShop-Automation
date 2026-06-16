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
        return driver.findElement(productTitle).isDisplayed();
    }

    public boolean isNoResultMessageDisplayed(){
        return driver.findElement(noResultsMessage).isDisplayed();
    }

}
