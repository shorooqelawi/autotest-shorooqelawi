package Test;

import Pages.Login;
import Utilities.TestBase_1;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class LoginTest extends TestBase_1 {



        Login Loginelment;

    @Test
    public void loginTest() throws InterruptedException{
        Loginelment = new Login(driver);
        Loginelment.login("problem_user", "secret_sauce");

        Thread.sleep(2000);
    }

    @Test
    public void loginTest_2() throws InterruptedException{
        Loginelment = new Login(driver);
        Loginelment.login_2("problem_user", "secret_sauce");
        Thread.sleep(2000);


    }

}
