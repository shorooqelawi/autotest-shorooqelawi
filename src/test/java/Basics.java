import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Basics {

//    public static void main(String[] args) {
//        System.out.println("Hello Shorooq");
//    }

//    public static void main(String[] args) throws InterruptedException {
//        String driverPath = "src/main/resources/chromedriver.exe";
//
//        System.setProperty("webdriver.chrome.driver", driverPath);
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.google.com");
//
//        System.out.println("Page Title: "+ driver.getTitle());
//
//        Thread.sleep((5000));
//
//        driver.quit();
//
//    }

//        public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://www.google.com");
//        System.out.println("Page Title: "+ driver.getTitle());
//
//        Thread.sleep(5000);
//
//        driver.quit();
//    }
 WebDriver driver = new ChromeDriver();
//
//    public static void main(String[] args) throws InterruptedException {
//
//        driver.get("https://www.google.com");
//        System.out.println("Page Title: "+ driver.getTitle());
//
//        Thread.sleep(5000);
//
//        driver.quit();
//    }


//@Test
//
//public void BrowserCommands() throws InterruptedException{
//
//    driver.get("https://www.google.com");
//
//
//    driver.navigate().to("https://chatgpt.com/");
//
//    driver.navigate().back();
//
//    driver.navigate().refresh();
//
//    driver.quit();
//}

//@Test
//
//    public void MaximzeWindow() throws InterruptedException{
//
//    driver.get("https://www.google.com");
//    Thread.sleep(5000);
//    driver.manage().window().maximize();
//    Thread.sleep(5000);
//    driver.quit();
//}
//
//@Test
//    public void BrowserOptions() throws InterruptedException{
//    ChromeOptions options = new ChromeOptions();
//
//
//    options.addArguments("--start-maximized");
//    //options.addArguments("--window-size=1920,1080");
//    options.addArguments("--ignore-certificate-errors");
//    options.addArguments("--incognito");
//    options.addArguments("--diable-extensions");
//
//    WebDriver driver = new ChromeDriver(options);
//
//    driver.get("https://www.google.com");
//    Thread.sleep(5000);
//    driver.quit();
//
//}

//@Test
//    public void BrowserHeadLess() throws InterruptedException{
//    ChromeOptions options = new ChromeOptions();
//
//    options.addArguments("--headless=new");
//
//    WebDriver driver = new ChromeDriver(options);
//
//    driver.get("https://www.google.com");
//    System.out.println("Page Title: "+ driver.getTitle());
//
//    Thread.sleep(5000);
//    driver.quit();
//
//}

//    @Test
//    public void Locater() throws InterruptedException{
//        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
//
//        Thread.sleep(5000);
//    driver.quit();
//    }

//@Test
//
//    public void LogiTest() throws InterruptedException{
//
//    driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
//    Thread.sleep(5000);
//   driver.findElement(By.id("username")).sendKeys("shorooq");
//    //driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shorooq");
//
//    Thread.sleep(5000);
//    driver.findElement(By.id("username")).clear();
//    Thread.sleep(1000);
//    driver.findElement(By.id("username")).sendKeys("shorooq2");
//
//
//    driver.findElement(By.id("password")).sendKeys("shorooqpass");
//    driver.findElement(By.tagName("button")).click();
//    Thread.sleep(2000);
//
//    String errorMessage = driver.findElement(By.xpath(
//            "/html/body/div[1]/div/div/div[1]")).getText();
//    Thread.sleep(2000);
//
//    System.out.println("error message: "+ errorMessage);
//    Thread.sleep(5000);
//    driver.quit();
//}

@Test
    public void js() throws InterruptedException{
    driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
    Thread.sleep(2000);


    WebElement UserName = driver.findElement(By.id("username"));
    WebElement Password = driver.findElement(By.id("password"));
    WebElement LoginButton = driver.findElement(By.tagName("button"));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript("arguments[0].value = arguments[1];", UserName,"shorooq");
    js.executeScript("arguments[0].value = arguments[1];", Password,"newpass");
    js.executeScript("arguments[0].click();", LoginButton);

    Thread.sleep(5000);
    driver.quit();

}

    @Test
    public void RelativeLocator() throws InterruptedException {

        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("user");

        WebElement passwordfield= driver.findElement(with(By.tagName("input")).below(username));

        passwordfield.sendKeys("shorooq");
        Thread.sleep(2000);
        driver.quit();


    }

    @Test
    public void Action() throws InterruptedException{
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("username"));
        WebElement Password = driver.findElement(By.name("password"));
        WebElement LoginButton = driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
        actions.sendKeys(username,"shorooq").perform();
        actions.sendKeys(Password,"pass").perform();
        actions.click(LoginButton).perform();
        LoginButton.click();
        Thread.sleep(2000);
        driver.quit();


    }

}
