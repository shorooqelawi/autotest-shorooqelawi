package old_code;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Basics_3 {
    WebDriver driver = new ChromeDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Test
    public void Explicit_Wait() {
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
        WebElement elementComplete = fluentWait.until(driver -> driver.findElement(By.xpath("(//button[@type='button'])[2]")));

        elementComplete.click();
        System.out.println("Result: " + elementComplete.getText());
        driver.quit();
    }



}
