    package com.nikhil.automation.pages;

    import com.nikhil.automation.components.HeaderComponent;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class ProductPage extends BasePage {

        private By addToCartButton = By.id("add-to-cart-button-31");
        private By addToWishlistButton = By.id("add-to-wishlist-button-43");

        public ProductPage(WebDriver driver){
            super(driver);
        }

        public ProductPage addToCart(){
            HeaderComponent headerComponent = getHeader();
            int currentCount = headerComponent.getCartCount();
            click(addToCartButton);
            headerComponent.waitForCartCount(currentCount+1);
            return this;
        }
        public ProductPage addToWishlist(){
            click(addToWishlistButton);
            return this;
        }
    }
