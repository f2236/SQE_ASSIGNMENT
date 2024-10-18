package com.automation.framework.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.framework.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private WebDriver driver;

	@Before
	public void setup() {
		// Initialize WebDriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SmartTech\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		// Initialize LoginPage
		LoginPage loginPage = new LoginPage(driver);
		driver.manage().window().maximize(); // Optional: Maximize the browser window
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the browser
		}
	}
}
