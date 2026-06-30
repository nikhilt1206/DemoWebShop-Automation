package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private By checkoutHeader = By.cssSelector(".page-title h1");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public boolean isCheckoutPageDisplayed(){
        return isDisplayed(checkoutHeader);
    }

}
