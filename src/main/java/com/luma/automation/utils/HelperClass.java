package com.luma.automation.utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class HelperClass {

    public static HelperClass helperClass;

    public static WebDriver driver;
    public static Actions act;
    public static FluentWait<WebDriver> wait;
    public final static int TIMEOUT = 30;

    public HelperClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        act= new Actions(driver);
        driver.manage().window().maximize();
        act = new Actions(driver);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }
    //---------Operational methods--------//
    //---------click the element----------//
    public static void clickOnElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        act.click(getDriver().findElement(element)).perform();
    }
    //--------fill the Element--------//
    public static void fillTheElement(By element, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        act.sendKeys(getDriver().findElement(element), data).perform();
    }
    //---------moveToElement-------//
    public static void moveToElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        act.moveToElement(getDriver().findElement(element)).perform();
    }
    public static void setUpDriver() {

        if (helperClass==null) {

            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }

}