package Pages;

import Utilities.ExtentManager;
import Utilities.TestBase_1;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class Login_2 extends TestBase_1 {


    public Login_2(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Login_2 Loginelment;
    Product Product = new Product(driver);
    CheckOut checkOutPage;
    Cart cartPage;

    @BeforeMethod
    public void setUp() {
        Loginelment = new Login_2(driver);
        Product = new Product(driver);
        cartPage = new Cart(driver);
        checkOutPage= new CheckOut(driver);
    }


    @FindAll(
            {
                @FindBy(id = "user-name"),
                @FindBy(name = "user-name")
            }
    )
    WebElement userName;


//    @FindBy(id = "user-name")
//    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement LoginButton;

    @FindBy(id ="h3")
    public static WebElement Errormessaged;

    private void enterUserName(String userNamevalue) {

        sendKey(userName,userNamevalue);


    }

    private void enterPassword(String PasswordValue) {

        sendKey(password,PasswordValue);
    }

    private void TapLoginbutton() {
       click(LoginButton);
    }


    public void Login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        TapLoginbutton();

        if(ExtentManager.getTest() !=null){
            ExtentManager.getTest().log(Status.INFO,"Login Screen");
            ExtentManager.getTest().log(Status.INFO,"Used_UserName: "+ userName);
            ExtentManager.getTest().log(Status.INFO,"Used_Password: "+password);

        }

    }

    public void Login_2(String userNamevalue, String PasswordValue) {
        sendKey(userName,userNamevalue);//good code
       // userName.sendKeys(userNamevalue);//bad code
        sendKey(password,PasswordValue);
        click(LoginButton);

    }



}