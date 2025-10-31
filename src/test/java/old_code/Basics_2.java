package old_code;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Basics_2 {


    WebDriver driver = new ChromeDriver();


    @Test
    public void ElementScreenshot() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest/");
        Thread.sleep(2000); WebDriver driver = new ChromeDriver();

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
        soft.assertEquals(logo,"Swag Labs","Logo is not right");
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }

    @Test
    public void FindElements() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo=    driver.findElement(By.className("app_logo")).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(logo,"Swag Labs","Logo is not right");
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        soft.assertEquals(items.size(),6,"Items are not right");
        items.get(3).click();
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }

    @Test
    public void implicitlyWait() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        //Thread.sleep(2000);// hard codded pause - bad code

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo=    driver.findElement(By.className("app_logo")).getText();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(logo,"Swag Labs","Logo is not right");


        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        soft.assertEquals(items.size(),6,"Items are not right");
        items.get(3).click();

        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }

    @Test
    public void Explicit_Wait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/");
        //  Thread.sleep(3000);

        WebElement iframeElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframeElement);

        //   driver.findElement(By.id("downloadButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downloadButton")));

        element.click();

        WebElement elementcomplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Complete!']")));
        elementcomplete.click();
        System.out.println("Result: "+elementcomplete.getText());
        Thread.sleep(2000);
        driver.quit();


    }
    @Test
    public void Fluent_Wait() {
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/");

        WebElement iframeElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframeElement);

        //  driver.findElement(By.id("downloadButton")).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement element= fluentWait.until(driver -> driver.findElement(By.id("downloadButton")));
        element.click();
        // Use either wait (pick one). Here using webDriverWait:
        WebElement elementComplete = fluentWait.until(driver -> driver.findElement(By.xpath("//div[text()='Complete!']")));

        elementComplete.click();
        System.out.println("Result: " + elementComplete.getText());
        driver.quit();
    }



}