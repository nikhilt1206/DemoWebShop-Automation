package com.nikhil.automation.pages;

import com.nikhil.automation.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private By shoppingCartHeader = By.cssSelector(".page-title h1");
    private By productName = By.className("product-name");
    private By termsAndConditionsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");
    private By removeProductCheckbox = By.cssSelector(".remove-from-cart input");
    private By updateShoppingCartButton = By.cssSelector(".update-cart-button");
    private By emptyCartMessage = By.className("order-summary-content");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public HeaderComponent getHeader(){
        return new HeaderComponent(driver);
    }

    public boolean isCartPageDisplayed(){
        return isDisplayed(shoppingCartHeader);
    }

    public String getProductName(){
        return getText(productName);
    }

    public void acceptTermsAndConditions(){
        click(termsAndConditionsCheckbox);
    }

    public void  clickCheckout(){
        click(checkoutButton);
    }

    public void removeProductFromCart(){
        click(removeProductCheckbox);
        click(updateShoppingCartButton);
    }

    public String getEmptyCartMessage(){
        return getText(emptyCartMessage);
    }
}
