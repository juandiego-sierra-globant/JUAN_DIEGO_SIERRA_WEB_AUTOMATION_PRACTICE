package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Enters the username into the username field
    public void enterUsername(String username) {
        (usernameField).sendKeys(username);
    }

    // Enters the password into the password field
    public void enterPassword(String password) {
       (passwordField).sendKeys(password);
    }

    // Clicks the login button
    public void clickLoginButton() {
        (loginButton).click();
    }
}
