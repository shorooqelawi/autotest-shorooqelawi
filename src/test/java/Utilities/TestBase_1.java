package Utilities;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
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
            options.addArguments("--headless=new");
        driver = new ChromeDriver(options);}
        else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/");
       // Thread.sleep(2000);
    }


@AfterMethod(alwaysRun = true)
public void QuitDriver()throws InterruptedException{
   if(driver != null){
      // Thread.sleep(2000);
       driver.quit();}
}

    private void waitElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void click(WebElement element) {
        waitElementToBeVisible(element);
        element.click();
    }



    public void sendKey(WebElement element, String text) {
        waitElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

}