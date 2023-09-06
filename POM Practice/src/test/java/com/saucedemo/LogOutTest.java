package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogOutTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LogOutPage logOutPage;


    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        logOutPage = new LogOutPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void loginTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Did not reach the expected login page");
    }

    @Test(alwaysRun = true)
    public void logOutTest(){
        logOutPage.clickBurger();
        logOutPage.clickLogOut();
        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Did not reach the expected logout page");
    }


}
