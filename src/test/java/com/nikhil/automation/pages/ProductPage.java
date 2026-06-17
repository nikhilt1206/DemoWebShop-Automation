package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By addToCartButton = By.id("add-to-cart-button-31");
    private By cartQuantity = By.className("cart-qty");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public ProductPage addToCart(){
        click(addToCartButton);
        waitForTextToBePresent(cartQuantity,"(1)");
        return this;
    }

    public String getCartCountText(){
        return getText(cartQuantity);
    }
}
