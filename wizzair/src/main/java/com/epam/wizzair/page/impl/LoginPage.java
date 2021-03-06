package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public class LoginPage extends AbstractPage {

    private final String BASE_URL = "https://wizzair.com/";

    @FindBy(xpath = "//ul[@class='navigation__container']/li[3]")
    private WebElement signInButton;

    @FindBy(xpath = "//form[@name='login-form']//input[@type='email']")
    private WebElement emailField;


    @FindBy(xpath = "//form[@name='login-form']//input[@type='password']")
    private WebElement passwordField;


    @FindBy(xpath = "//form[@name='login-form']//button[@type='submit']")
    private WebElement submitSingInButton;



    public LoginPage(WebDriver driver){
        //super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void login(String email, String password){
        signInButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitSingInButton.click();
    }
}