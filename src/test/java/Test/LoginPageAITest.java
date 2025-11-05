package Test;

import Pages.LoginPageAI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPageAITest {

    private WebDriver driver;
    private LoginPageAI loginPageAI;

    @BeforeEach
    void setUp() {
        // In a real framework, this would be handled by a WebDriverManager or a similar utility
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize the Page Object Model class
        this.loginPageAI = new LoginPageAI(driver);

        // Navigate to the target page
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testSuccessfulLogin() {
        // Use the public method from the POM to perform the login action
        loginPageAI.Login("standard_user", "secret_sauce");

        // The provided POM does not have methods to verify the outcome of the login.
        // In a real scenario, you would add methods to the next page's POM
        // (e.g., ProductsPage) to verify elements are present.
        // For this demonstration, we will assert the URL changes.
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Login was not successful, URL did not change to the inventory page.");

        // TODO: Add a proper assertion here to verify the outcome,
        // for example, by checking for a specific element on the products page.
    }
}