package com.nikhil.automation.pages;

import com.nikhil.automation.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private By shoppingCartHeader = By.cssSelector(".page-title h1");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public HeaderComponent getHeader(){
        return new HeaderComponent(driver);
    }

    public boolean isCartPageDisplayed(){
        return isDisplayed(shoppingCartHeader);
    }
}
