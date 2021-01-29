package com.dkstalis.utills;

import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


public class SeleniumUtils {


    public static WebDriver driver;
    public static SeleniumUtils selenium;
    public static Scenario currentScenario;

    public SeleniumUtils() {

    }


    public static SeleniumUtils getInstance() {
        if (selenium == null){selenium = new SeleniumUtils();}
        return selenium;
    }



    public WebDriver getDriver(){
        return driver;
    }

    public void launchApp(){
            System.out.println("Opening Chrome Browser...");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resource/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://demo.midtrans.com");
        Assert.assertEquals("Verifying Title of Home page: ", "Sample Store", driver.getTitle().trim());

    }

    public void click(By by){

        driver.findElement(by).click();
    }

    public void switchFrame(int index){
        driver.switchTo().frame(index);
    }

    public void swithToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public boolean exists(By by){
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void enterText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void quit(){
        if(driver != null){
            driver.quit();
        }
    }

    public void takeScreenshot(){
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        currentScenario.embed(screenshot, "image/png");
    }
}
