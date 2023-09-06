package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class RemoveTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private RemovingElements removingElements;
    private PurchaseProduct purchaseProduct;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        purchaseProduct = new PurchaseProduct(driver);
        removingElements = new RemovingElements(driver);
    }

    @BeforeClass(alwaysRun = true)
    public void loginTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @BeforeMethod(alwaysRun = true)
    public void purchaseTest() {
        removingElements.selectProducts();
    }

    @Test(alwaysRun = true)
    public void removingElements(){
        purchaseProduct.goToShoppingCart();
        removingElements.removeItems();
   }

    @AfterMethod(alwaysRun = true)
    public void checkIsEmpty(){
        List<WebElement> removeButtons = driver.findElements(By.cssSelector("button[name^='remove-sauce-labs-']"));
        // Verify that the list of "Remove" buttons is empty
        Assert.assertEquals(removeButtons.size(), 0, "The list of 'Remove' buttons is not empty");
    }
}
