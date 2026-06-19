package com.nikhil.automation.components;

import com.nikhil.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {

    private By cartQuantity = By.className("cart-qty");

    public HeaderComponent(WebDriver driver){
        super(driver);
    }

    public String getCartCountText(){
        return getText(cartQuantity);
    }

    public void waitForCartCount(String expectedCount){
        waitForTextToBePresent(cartQuantity,expectedCount);
    }
}
