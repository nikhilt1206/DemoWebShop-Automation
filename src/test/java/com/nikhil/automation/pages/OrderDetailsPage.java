    package com.nikhil.automation.pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class OrderDetailsPage extends BasePage{

        private By productName = By.cssSelector("td.a-left.name a");
        private By productPrice = By.cssSelector("td.a-right.price");
        private By quantity = By.cssSelector("td.a-center.quantity");
        private By totalPrice = By.cssSelector("td.a-right.total");

        public OrderDetailsPage(WebDriver driver){
            super(driver);
        }

        public String getProductName() {
            return getText(productName);
        }

        public int getQuantity(){
            return Integer.parseInt(getText(quantity).trim());
        }

        public double getProductPrice() {
            return Double.parseDouble(getText(productPrice).trim());
        }

        public double getTotalPrice() {
            return Double.parseDouble(getText(totalPrice).trim());
        }
    }
