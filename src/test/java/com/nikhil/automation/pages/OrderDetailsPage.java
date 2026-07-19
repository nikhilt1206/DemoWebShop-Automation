    package com.nikhil.automation.pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class OrderDetailsPage extends BasePage{

        private By productName = By.cssSelector("td.a-left.name a");

        public OrderDetailsPage(WebDriver driver){
            super(driver);
        }

        public String getProductName() {
            return getText(productName);
        }
    }
