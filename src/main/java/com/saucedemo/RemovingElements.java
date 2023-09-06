package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemovingElements {

    private WebDriver driver;

    @FindBy(css = "button[name='add-to-cart-sauce-labs-backpack']")
    private WebElement firstProductButton;

    @FindBy(css = "button[name='add-to-cart-sauce-labs-bike-light']")
    private WebElement secondProductButton;

    @FindBy(css = "button[name='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement thirdProductButton;

    @FindBy(css = "button[name='remove-sauce-labs-backpack']")
    private WebElement removeFirstProductButton;

    @FindBy(css = "button[name='remove-sauce-labs-bike-light']")
    private WebElement removeSecondProductButton;

    @FindBy(css = "button[name='remove-sauce-labs-bolt-t-shirt']")
    private WebElement removeThirdProductButton;

    public RemovingElements(WebDriver driver) {
        this.driver = driver;

        // Initialize elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Select products
    public void selectProducts() {
        firstProductButton.click();
        secondProductButton.click();
        thirdProductButton.click();
    }

    // Remove items from the cart
    public void removeItems() {
        removeFirstProductButton.click();
        removeSecondProductButton.click();
        removeThirdProductButton.click();
    }
}
