package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {

    private By successMessage=By.cssSelector(".section.order-completed .title");
    private By orderNumber=By.cssSelector(".details li");
    private By continueButton=By.cssSelector(".order-completed-continue-button");

    public OrderConfirmationPage(WebDriver driver){
        super(driver);
    }

    public boolean isOrderPlaced(){
        return isDisplayed(successMessage);
    }

    public String getOrderNumber(){
        String text = getText(orderNumber);
        String[] orderInfo = text.split(":");
        return orderInfo[1].trim();
    }

    public HomePage clickContinue(){
        click(continueButton);
        return new HomePage(driver);
    }
}
