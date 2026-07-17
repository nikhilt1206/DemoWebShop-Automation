package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage extends BasePage {

    private By getOrderNumberLocator(String orderNumber){
        return By.xpath("//strong[contains(text(),'"+orderNumber+"')]");
    }

    public OrdersPage(WebDriver driver){
        super(driver);
    }

    public boolean isOrderPresent(String orderNumber){
        return isDisplayed(getOrderNumberLocator(orderNumber));
    }
}
