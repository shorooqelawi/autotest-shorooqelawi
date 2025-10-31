package old_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class TestNG_2 {


    WebDriver driver;

@Parameters("browser")
    @BeforeMethod(groups = {"login","sanity"})
    public void beforeMethod(String browser)throws InterruptedException{
    ChromeOptions options = new ChromeOptions();

        if(browser.equals("chrome")){
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);}
        else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }


        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }
    @Test(priority = 1 , groups = {"login","sanity"})
    public void loginwithValidData() throws InterruptedException{

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo=    driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(logo,"Swag Labs","Logo is not right");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 2,groups = {"login","regression"})
    public void LoginWithInvalidData() throws InterruptedException{

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("seddddcret_sauce");
        driver.findElement(By.id("login-button")).click();
        SoftAssert soft = new SoftAssert();
        String error = driver.findElement(By.className("h3")).getText();
        soft.assertEquals(error,"Epic sadface: Username and password do not match any user in this service","Error message is not right");

        soft.assertAll();
    }

    @Test(priority = 3,groups = {"sanity"})
    public void FindElements() throws InterruptedException{

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo=    driver.findElement(By.className("app_logo")).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(logo,"Swag Labs","Logo is not right");
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        soft.assertEquals(items.size(),6,"Items are not right");
        items.get(3).click();

        soft.assertAll();
    }

    @Test(dependsOnMethods = "loginwithValidData")
    public void dependOnMethod() throws InterruptedException{


        SoftAssert soft = new SoftAssert();
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        soft.assertEquals(items.size(),6,"Items are not right");
        items.get(3).click();

        soft.assertAll();
    }

@AfterMethod
public void QuitDriver()throws InterruptedException{
   if(driver != null){
       Thread.sleep(2000);
       driver.quit();}
}


}