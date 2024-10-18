package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	// WebElements for the login page
	@FindBy(id = "username") // Replace with the actual ID or selector of your username field
	private WebElement usernameField;

	@FindBy(id = "password") // Replace with the actual ID or selector of your password field
	private WebElement passwordField;

	@FindBy(id = "loginButton") // Replace with the actual ID or selector of your login button
	private WebElement loginButton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// Initialize WebElements
		PageFactory.initElements(driver, this);
	}

	// Method to enter username
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	// Method to enter password
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	// Method to click the login button
	public void clickLogin() {
		loginButton.click();
	}

	// Optional: You can add methods to perform a full login
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
}
