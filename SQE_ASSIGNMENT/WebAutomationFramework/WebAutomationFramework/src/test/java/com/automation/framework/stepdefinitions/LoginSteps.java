package com.automation.framework.stepdefinitions;

import com.automation.framework.pages.LoginPage;
import io.cucumber.java.After; // Import After
import io.cucumber.java.Before; // Import Before
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step; // Import Allure Step
import io.qameta.allure.Description; // Import Allure Description
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before // Run this before each scenario
    public void setup() {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Initialize LoginPage
        loginPage = new LoginPage(driver);
    }

    @Given("the user is on the login page")
    @Step("Navigate to the login page") // Allure Step
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.instagram.com/accounts/login/");
    }

    @When("the user enters {string} and {string}")
    @Step("User enters username: {0} and password: {1}") // Allure Step with parameters
    public void the_user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the homepage")
    @Step("Verify user redirection to homepage") // Allure Step
    public void the_user_should_be_redirected_to_the_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated wait
        wait.until(ExpectedConditions.urlContains("instagram.com"));
        assertTrue(driver.getCurrentUrl().contains("instagram.com"));
    }

    @When("the user enters invalid credentials")
    @Step("User enters invalid credentials") // Allure Step
    public void the_user_enters_invalid_credentials() {
        loginPage.enterUsername("invalid_username"); // Use an invalid username
        loginPage.enterPassword("invalid_password"); // Use an invalid password
        loginPage.clickLogin();
    }

    @Then("an error message should be displayed")
    @Step("Verify error message is displayed") // Allure Step
    public void an_error_message_should_be_displayed() {
        // Assuming the error message has an ID of "error-message"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
        assertTrue(driver.findElement(By.id("error-message")).isDisplayed());
    }

    @After // Run this after each scenario
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }
}
