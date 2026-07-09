package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nikhil.automation.pojo.BillingAddress;

public class CheckoutPage extends BasePage {

    private By checkoutHeader = By.cssSelector(".page-title h1");
    private By billingAddressContinueButton = By.cssSelector(".new-address-next-step-button");
    private By inStorePickupCheckbox = By.id("PickUpInStore");
    private By shippingAddressContinueButton = By.cssSelector("input[onclick='Shipping.save()']");
    private By groundShippingMethodRadioButton = By.id("shippingoption_0");
    private By shippingMethodContinueButton = By.cssSelector("input[onclick='ShippingMethod.save()']");
    private By cashOnDeliveryRadioButton = By.id("paymentmethod_0");
    private By paymentMethodContinueButton = By.cssSelector("input[onclick='PaymentMethod.save()']");
    private By paymentInformationContinueButton = By.cssSelector("input[onclick='PaymentInfo.save()']");
    private By confirmOrderContinueButton = By.cssSelector("input[onclick='ConfirmOrder.save()']");
    private By orderConfirmSuccessMessage = By.cssSelector(".order-completed .title strong");

    // Guest Billing Address
    private By firstNameTextBox = By.id("BillingNewAddress_FirstName");
    private By lastNameTextBox = By.id("BillingNewAddress_LastName");
    private By emailTextBox = By.id("BillingNewAddress_Email");
    private By countryDropdown = By.id("BillingNewAddress_CountryId");
    private By cityTextBox = By.id("BillingNewAddress_City");
    private By address1TextBox = By.id("BillingNewAddress_Address1");
    private By zipCodeTextBox = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberTextBox = By.id("BillingNewAddress_PhoneNumber");
    private By billingAddressContinueBtn = By.cssSelector("input[onclick='Billing.save()']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutPageDisplayed() {
        return isDisplayed(checkoutHeader);
    }

    public void clickBillingAddressContinue() {
        click(billingAddressContinueButton);
    }

    public boolean isInStorePickupCheckboxDisplayed() {
        return isDisplayed(inStorePickupCheckbox);
    }

    public void clickShippingAddressContinue() {
        click(shippingAddressContinueButton);
    }

    public boolean isGroundShippingMethodDisplayed() {
        return isDisplayed(groundShippingMethodRadioButton);
    }

    public void clickShippingMethodContinue(){
        click(shippingMethodContinueButton);
    }

    public boolean isCashOnDeliveryDisplayed(){
        return isDisplayed(cashOnDeliveryRadioButton);
    }

    public void clickPaymentMethodContinue(){
        click(paymentMethodContinueButton);
    }

    public void clickPaymentInformationContinue(){
        click(paymentInformationContinueButton);
    }

    public void clickConfirmOrderContinue(){
        click(confirmOrderContinueButton);
    }

    public boolean isOrderConfirmSuccessMessageDisplayed(){
        return isDisplayed(orderConfirmSuccessMessage);
    }

    public void fillBillingAddress(BillingAddress billingAddress){
        enterDetails(firstNameTextBox,billingAddress.getFirstName());
        enterDetails(lastNameTextBox,billingAddress.getLastName());
        enterDetails(emailTextBox,billingAddress.getEmail());
        selectByVisibleText(countryDropdown,billingAddress.getCountry());
        enterDetails(cityTextBox,billingAddress.getCity());
        enterDetails(address1TextBox,billingAddress.getAddress());
        enterDetails(zipCodeTextBox,billingAddress.getZipCode());
        enterDetails(phoneNumberTextBox,billingAddress.getPhoneNumber());
    }

}
