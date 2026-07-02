package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private By checkoutHeader = By.cssSelector(".page-title h1");
    private By billingAddressContinueButton = By.cssSelector(".new-address-next-step-button");
    private By inStorePickupCheckbox = By.id("PickUpInStore");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public boolean isCheckoutPageDisplayed(){
        return isDisplayed(checkoutHeader);
    }

    public void clickBillingAddressContinue(){
        click(billingAddressContinueButton);
    }

    public boolean isInStorePickupCheckboxDisplayed(){
        return isDisplayed(inStorePickupCheckbox);
    }


}
