package com.luma.automation.utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;

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
    //click the element//
    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        act.click(element).perform();
    }
    //fill the Element//
    public static void fillTheElement(WebElement element,String data) {
        wait.until(ExpectedConditions.visibilityOf(element));
        act.sendKeys(element,data).perform();
    }
    //moveToElement//
    public static void moveToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        act.moveToElement(element).perform();
    }
    public static void sleepTime() throws InterruptedException {
        Thread.sleep(5000);
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