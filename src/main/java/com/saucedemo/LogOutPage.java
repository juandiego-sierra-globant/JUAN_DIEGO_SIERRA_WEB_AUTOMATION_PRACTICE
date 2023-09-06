package com.saucedemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LogOutPage {

    private WebDriver driver;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burger;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutSidebar;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBurger(){
        burger.click();
    }
    public void clickLogOut(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logoutSidebar.click();
    }


}
