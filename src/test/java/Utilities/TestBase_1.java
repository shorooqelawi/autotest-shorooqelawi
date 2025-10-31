package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class TestBase_1 {


   public WebDriver driver;

@Parameters("browser")
    @BeforeMethod()
    public void beforeMethod(@Optional("chrome")String browser)throws InterruptedException{

        if(browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);}
        else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }


@AfterMethod()
public void QuitDriver()throws InterruptedException{
   if(driver != null){
       Thread.sleep(2000);
       driver.quit();}
}


}