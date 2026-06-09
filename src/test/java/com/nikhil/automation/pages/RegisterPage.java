package com.nikhil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    private By maleRadioButton = By.id("gender-male");
    private By femaleRadioButton = By.id("gender-female") ;
    private By firstNameTextBox = By.id("FirstName");
    private By lastNameTextBox = By.id("LastName");
    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Password");
    private By confirmPasswordTextBox = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By registrationSuccessMessage = By.cssSelector(".result");


    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public void selectGender(String gender){
        if(gender.equalsIgnoreCase("male")){
            click(maleRadioButton);
        }
        else if(gender.equalsIgnoreCase("female")){
            click(femaleRadioButton);
        }
    }

    public void enterFirstName(String firstName){
        enterDetails(firstNameTextBox,firstName);
    }

    public void enterLastName(String lastName){
        enterDetails(lastNameTextBox,lastName);
    }

    public void enterEmail(String email){
        enterDetails(emailTextBox,email);
    }

    public void enterPassword(String password){
        enterDetails(passwordTextBox,password);
    }

    public void enterConfirmPassword(String confirmPassword){
        enterDetails(confirmPasswordTextBox,confirmPassword);
    }

    public void clickRegister(){
        click(registerButton);
    }

    public String getRegistrationSuccessMessage(){
        return getText(registrationSuccessMessage);
    }
}
