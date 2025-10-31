package old_code;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;


public class Challenge {

    WebDriver driver = new ChromeDriver();

    @Test
    public void SelectmultipleItem() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-elements/#Multiple%20Selection");
        Thread.sleep(2000);

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement item1 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[1]"));
        WebElement item2 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[2]"));
        WebElement item3 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[3]"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(item1)
                .click(item2)
                .click(item3)
                .keyUp(Keys.CONTROL)
                .perform();

         driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.quit();

    }


}
