package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    // Page elements
    @FindBy(xpath = "//div[@role='navigation']")
    WebElement navigationBar;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the page
    public boolean isNavigationBarDisplayed() {
        return navigationBar.isDisplayed();
    }
}
