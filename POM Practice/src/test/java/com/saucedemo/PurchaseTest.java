package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PurchaseTest {

    private WebDriver driver;
    private PurchaseProduct purchaseProduct;


    private LoginPage loginPage;

    @BeforeTest(alwaysRun = true)
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        purchaseProduct = new PurchaseProduct(driver);
    }

    @BeforeClass(alwaysRun = true)
    public void loginTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Did not reach the expected login page");
    }

    @BeforeMethod(alwaysRun = true)
    public void purchaseTest() {
        purchaseProduct.selectProduct();
        purchaseProduct.goToShoppingCart();
        purchaseProduct.goToCheckout();
    }

    @Test(alwaysRun = true)
    public void completeCheckout(){
        purchaseProduct.enterFirstName("Juan");
        purchaseProduct.enterLastName("Sierra");
        purchaseProduct.enterZipCode("12345");
        purchaseProduct.clickContinue();
    }

    @AfterMethod(alwaysRun = true)
    public void clickFinish(){
        purchaseProduct.clickFinish();
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Did not reach the expected completion page");
    }
}
