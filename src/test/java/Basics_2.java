import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Basics_2 {


 WebDriver driver = new ChromeDriver();


    @Test
    public void ElementScreenshot() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest/");
        Thread.sleep(2000);
        WebElement Logo = driver.findElement(By.id("logo"));
        File file =Logo.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("Screenshots/Logo.png"));

        }catch (IOException e){
            throw new RuntimeException();
        }
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void HardAssertions() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

    String logo=    driver.findElement(By.className("app_logo")).getText();
        Thread.sleep(2000);
     Assert.assertEquals(logo,"Swag Labs","Logo is not right");

//        String expectedtitle= "Swag Labs";
//        String actualtitle = driver.getTitle();
//        Assert.assertEquals(actualtitle,expectedtitle);
        driver.quit();
    }

    @Test
    public void HardAssertionstrue() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String logo=    driver.findElement(By.className("app_logo")).getText();
        Thread.sleep(2000);
        Assert.assertTrue(logo.contains("Swag"),"Logo is not right");

        driver.quit();
    }

    @Test
    public void HardAssertionsfalse() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String logo=    driver.findElement(By.className("app_logo")).getText();
        Thread.sleep(2000);
        Assert.assertFalse(logo.contains("not Swag"),"Logo is  right");


        driver.quit();
    }

    @Test
    public void HardAssertionstrueNotEquals() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String logo=    driver.findElement(By.className("app_logo")).getText();
        Thread.sleep(2000);
        Assert.assertNotEquals(logo,"Swag Labs");

        Assert.fail("fail");

        driver.quit();
    }

    @Test
    public void SoftAssertion() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo=    driver.findElement(By.className("app_logo")).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(logo,"Swafgg Labs","Logo is not right");
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }


}