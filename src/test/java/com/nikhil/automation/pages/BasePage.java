package com.nikhil.automation.pages;

import com.nikhil.automation.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
    }

    public void click(By locator){
        wait.until(elementToBeClickable(locator)).click();
    }

    public void enterDetails(By locator, String text){
        WebElement element = wait.until(visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(By locator){
        return wait.until(visibilityOfElementLocated(locator)).isDisplayed();
    }

    public String getText(By locator){
        return wait.until(visibilityOfElementLocated(locator)).getText();
    }

    public void waitForTextToBePresent(By locator, String text){
        wait.until(textToBePresentInElementLocated(locator,text));
    }

    public String getAttribute(By locator, String attributeName){
        WebElement element = wait.until(visibilityOfElementLocated(locator));
        return element.getAttribute(attributeName);
    }
}
