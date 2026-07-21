    package com.nikhil.automation.pages;

    import com.nikhil.automation.pojo.BillingAddress;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class OrderDetailsPage extends BasePage{

        private By productName = By.cssSelector("td.a-left.name a");
        private By productPrice = By.cssSelector("td.a-right.price");
        private By quantity = By.cssSelector("td.a-center.quantity");
        private By totalPrice = By.cssSelector("td.a-right.total");

        private By billingName = By.cssSelector(".billing-info .name");
        private By billingEmail = By.cssSelector(".billing-info .email");
        private By billingPhone = By.cssSelector(".billing-info .phone");
        private By billingAddress = By.cssSelector(".billing-info .address1");
        private By billingCityStateZip = By.cssSelector(".billing-info .city-state-zip");
        private By billingCountry = By.cssSelector(".billing-info .country");

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

        public BillingAddress getBillingAddress(){
            String fullName = getText(billingName).trim();
            String[] name = fullName.split(" ");
            String firstName = name[0];
            String lastName = name[1];
            String email = getText(billingEmail).replace("Email: ","");
            String phone = getText(billingPhone).replace("Phone: ","");
            String address = getText(billingAddress).trim();
            String[] cityZip = getText(billingCityStateZip).split(",");
            String city = cityZip[0].trim();
            String zip = cityZip[1].trim();
            String country = getText(billingCountry).trim();
            return new BillingAddress(
                    firstName,
                    lastName,
                    email,
                    country,
                    city,
                    address,
                    zip,
                    phone
            );
        }

    }
