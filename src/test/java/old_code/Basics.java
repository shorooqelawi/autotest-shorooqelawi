package old_code;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

//    @Test
//    public void RelativeLocator() throws InterruptedException {
//
//        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
//        Thread.sleep(2000);
//
//        WebElement username = driver.findElement(By.id("username"));
//        username.sendKeys("user");
//
//        WebElement passwordfield= driver.findElement(with(By.tagName("input")).below(username));
//
//        passwordfield.sendKeys("shorooq");
//        Thread.sleep(2000);
//        driver.quit();
//
//
//    }

//    @Test
//    public void Action() throws InterruptedException{
//        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
//        Thread.sleep(2000);
//        WebElement username = driver.findElement(By.id("username"));
//        WebElement Password = driver.findElement(By.name("password"));
//        WebElement LoginButton = driver.findElement(By.tagName("button"));
//        Actions actions = new Actions(driver);
//        actions.sendKeys(username,"shorooq").perform();
//        actions.sendKeys(Password,"pass").perform();
//        actions.click(LoginButton).perform();
//        LoginButton.click();
//        Thread.sleep(2000);
//        driver.quit();
//
//
//    }

    @Test
    public void Dropdowns() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        Thread.sleep(2000);
        WebElement country = driver.findElement(By.tagName("select"));
        Select select = new Select(country);
        select.selectByVisibleText("Jordan");
        //select.selectByIndex(2); bad practice
        //select.selectByValue("JOR");
        //country.sendKeys("Jordan");

        List<WebElement> options = select.getOptions();

        System.out.println("Total: " + options.size());

        Thread.sleep(5000);
        driver.quit();
    }


//@Test
//    public void Alert() throws InterruptedException{
//    driver.manage().window().maximize();
//    driver.get("https://www.globalsqa.com/samplepagetest/");
//    Thread.sleep(2000);
//
//
//    WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
//    alertButton.click();
//    Thread.sleep(5000);
//
//    Alert confirmation = driver.switchTo().alert();
//
//    System.out.println("Alert value" +confirmation.getText());
//    confirmation.accept();
////   confirmation.dismiss();
//
//
//driver.quit();
//
//}

@Test
    public void  IFrame() throws InterruptedException{

    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
    Thread.sleep(2000);

    driver.switchTo().frame("globalSqa");

    WebElement logo = driver.findElement(By.xpath("//*[@id=\"logo\"]/div/a/img"));
    logo.click();

    Thread.sleep(5000);

    driver.switchTo().defaultContent();
    Thread.sleep(2000);

    driver.quit();

}

@Test
    public void Hover() throws InterruptedException{
    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#");
    Thread.sleep(2000);
    WebElement freeBooks = driver.findElement(By.xpath("//*[@id=\"menu-item-7128\"]/a"));

    Actions actions= new Actions(driver);
    actions.moveToElement(freeBooks).perform();
    Thread.sleep(2000);
driver.quit();

}

    @Test
    public void dragdrop() throws InterruptedException{

        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        Thread.sleep(2000);
        WebElement iframeElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframeElement);

        WebElement source = driver.findElement(By.xpath(""));
        WebElement target = driver.findElement(By.id("trash"));

        Actions actions= new Actions(driver);
        actions.dragAndDrop(source,target).perform();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void RightClick() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        WebElement UserName = driver.findElement(By.id("username"));
        Actions actions= new Actions(driver);
        actions.contextClick(UserName).perform();
        Thread.sleep(2000);
        driver.quit();

}

    @Test
    public void DoubleClick() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        WebElement Loginbutton = driver.findElement(By.tagName("button"));
        Actions actions= new Actions(driver);
        actions.doubleClick(Loginbutton).perform();
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void Keybordeventone() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("shorooq2");
        driver.findElement(By.id("password")).sendKeys("shorooqpass");
        // WebElement Loginbutton = driver.findElement(By.tagName("button"));
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void Keybordeventtwo() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("shorooq2");
        driver.findElement(By.id("password")).sendKeys("shorooqpass");
        // WebElement Loginbutton = driver.findElement(By.tagName("button"));
        Actions actions= new Actions(driver);
        Thread.sleep(2000);
        actions.keyDown(Keys.TAB).perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.TAB).perform();
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void Keybordeventthree() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("shorooq2");
        driver.findElement(By.id("password")).sendKeys("shorooqpass");
        // WebElement Loginbutton = driver.findElement(By.tagName("button"));
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void WindowsHandle() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        String orhandle = driver.getWindowHandle();
        System.out.println("original window: "+ orhandle);
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        System.out.println("new tab: " +driver.getTitle());

        Thread.sleep(3000);

        driver.switchTo().window(orhandle);

        Thread.sleep(3000);

        //driver.close(); to close one tab
        driver.quit();

    }

    @Test
    public void FileUpload() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest/");
        Thread.sleep(2000);
        WebElement fileupload = driver.findElement(By.name("file-553"));

        fileupload.sendKeys("C:\\Users\\shoro\\OneDrive\\الصور\\لقطات الشاشة\\Screenshot 2025-10-28 200007.png");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void Screenshot() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(src,new File("Screenshots/Homepage.png"));


        }catch (IOException e){
            throw new RuntimeException();
        }
        Thread.sleep(3000);
        driver.quit();
    }

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

}
