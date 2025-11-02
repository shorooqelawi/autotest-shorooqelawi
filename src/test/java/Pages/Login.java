package Pages;

import Utilities.TestBase_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends TestBase_1 {


    public Login(WebDriver driver) {
        this.driver = driver;
    }



    private By username = By.id("user-name");
    private By password = By.id("password");
    // If this is an ID (commonly is), prefer By.id
    private By loginButton = By.id("login-button");
    // when i use assertion i locat with public like this
    public  By logo = By.className("app_logo");


    private void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    private void TapLoginButton() {
        driver.findElement(this.loginButton).click();
    }
    public void login(String username, String password) {
        //best
       enterUsername(username);
       enterPassword(password);
       TapLoginButton();
    }

    public void login_2(String username, String password) {
//good
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();
    }
}
