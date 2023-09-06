package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseProduct {
    private WebDriver driver;

    @FindBy(css = "button[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement buttonAddToCart;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(css = "input[data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "input[data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "input[data-test='postalCode']")
    private WebElement zipCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(css = "button[data-test='finish']")
    private WebElement finishButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public PurchaseProduct(WebDriver driver) {
        this.driver = driver;

        // Initialize elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Select a product
    public void selectProduct() {
        buttonAddToCart.click();
    }

    // Go to the shopping cart
    public void goToShoppingCart() {
        shoppingCartLink.click();
    }

    // Go to the checkout
    public void goToCheckout() {
        checkoutButton.click();
    }

    // Enter first name
    public void enterFirstName(String firstname) {
        firstNameInput.sendKeys(firstname);
    }

    // Enter last name
    public void enterLastName(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    // Enter zip code
    public void enterZipCode(String zipcode) {
        zipCodeInput.sendKeys(zipcode);
    }

    // Click continue
    public void clickContinue() {
        continueButton.click();
    }

    // Click finish
    public void clickFinish() {
        finishButton.click();
    }
}
