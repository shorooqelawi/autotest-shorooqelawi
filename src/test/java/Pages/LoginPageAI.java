package Pages;

import Utilities.TestBase_1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAI extends TestBase_1 {

    public WebDriver driver;

    public LoginPageAI(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(id = "user-name"),
            @FindBy(name = "user-name")
    })
    WebElement userNameInput;

    @FindAll({
            @FindBy(id = "password"),
            @FindBy(name = "password")
    })
    WebElement passwordInput;

    @FindAll({
            @FindBy(id = "login-button"),
            @FindBy(name = "login-button")
    })
    WebElement loginButton;

    private void enterUserName(String userNamevalue) {
        sendKey(userNameInput, userNamevalue);
    }

    private void enterPassword(String passwordValue) {
        sendKey(passwordInput, passwordValue);
    }

    private void clickLoginButton() {
        click(loginButton);
    }

    public void Login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }
}