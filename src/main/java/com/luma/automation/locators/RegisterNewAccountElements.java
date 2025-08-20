package com.luma.automation.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterNewAccountElements {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement HrmUsernameInputField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement HrmPasswordInputField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement HrmLoginButton;

}

