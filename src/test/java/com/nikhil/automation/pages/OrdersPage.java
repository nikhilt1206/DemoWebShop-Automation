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

    private By getOrderDetailsButtonLocator(String orderNumber) {
        return By.xpath(
                "//strong[contains(text(),'" + orderNumber + "')]" +
                        "/ancestor::div[@class='section order-item']" +
                        "//input[@value='Details']"
        );
    }

    public OrderDetailsPage clickOrderDetails(String orderNumber){
        click(getOrderDetailsButtonLocator(orderNumber));
        return new OrderDetailsPage(driver);
    }
}
