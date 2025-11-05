package Pages;

import Utilities.TestBase_1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model for the Swag Labs Login Page.
 */
public class LoginPageAI extends TestBase_1 {

    /**
     * Locates the username input field using its ID.
     */
    @FindBy(id = "user-name")
    private WebElement usernameField;

    /**
     * Locates the password input field using its ID.
     */
    @FindBy(id = "password")
    private WebElement passwordField;

    /**
     * Locates the login button using its ID.
     */
    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Locates the container for error messages.
     */
    @FindBy(css = "div.error-message-container")
    private WebElement errorMessageContainer;

    /**
     * Enters the username and password into the respective fields and clicks the login button.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    /**
     * Checks if the username input field is visible on the page.
     *
     * @return true if the username field is displayed, false otherwise.
     */
    public boolean isUsernameFieldVisible() {
        return usernameField.isDisplayed();
    }

    /**
     * Checks if the password input field is visible on the page.
     *
     * @return true if the password field is displayed, false otherwise.
     */
    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    /**
     * Checks if the login button is visible on the page.
     *
     * @return true if the login button is displayed, false otherwise.
     */
    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }

    /**
     * Checks if the error message container is visible.
     * Note: The container might be visible even if it's empty.
     *
     * @return true if the error message container is displayed, false otherwise.
     */
    public boolean isErrorMessageContainerVisible() {
        return errorMessageContainer.isDisplayed();
    }
}