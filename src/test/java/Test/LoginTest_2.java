package Test;

import Pages.Cart;
import Pages.CheckOut;
import Pages.Login;
import Pages.Login_2;
import Pages.Product;
import Utilities.JSONReader;
import Utilities.TestBase_1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest_2 extends TestBase_1 {



    Login_2 Loginelment;
    Product Product = new Product(driver);
    CheckOut checkOutPage;
    Cart cartPage;

    @Test
    public void loginWithValidData() throws InterruptedException{
        Loginelment = new Login_2(driver);
        Product = new Product(driver);
        Loginelment.Login("problem_user", "secret_sauce");
        // Assert.assertEquals(Product.LogoGetText(),"Swag Labs");
        Assert.assertEquals(Product.appLogo.getText(),"Swag Labs");



    }
//@Test
//    public void loginWithInvalidData() throws InterruptedException{
//        Loginelment = new Login_2(driver);
//        Product = new Product(driver);
//        Loginelment.Login("problem_user", "Wrong_pass_secret_sauce");
//        // Assert.assertEquals(Product.LogoGetText(),"Swag Labs");
//        Assert.assertEquals(Product.appLogo.getText(),"Swag Labs","not the expected");
//
//
//    }
//
//    @Test
//    public void Locked_Out_User() throws InterruptedException{
//        Loginelment = new Login_2(driver);
//        Product = new Product(driver);
//        Loginelment.Login("locked_out_user", "secret_sauce");
//        // Assert.assertEquals(Product.LogoGetText(),"Swag Labs");
//        Assert.assertEquals(Login_2.Errormessaged.getText(),"Epic sadface: Sorry, this user has been locked out.");
//
//
//
//    }


    @Test
    public void checkoutFlow() throws InterruptedException {
        Loginelment = new Login_2(driver);
        Product = new Product(driver);
        checkOutPage = new CheckOut(driver);
        cartPage = new Cart(driver);

        Loginelment.Login("standard_user", "secret_sauce"); // you can keep problem_user if you want
        Thread.sleep(1500);

        Assert.assertEquals(Product.LogoGetText(), "Swag Labs");

        Product.addBackpackToCart();
        Thread.sleep(1000);
        Assert.assertEquals(Product.getCartBadgeCount(), 1, "Cart badge should be 1 after adding");

        Product.openCart();
        Thread.sleep(1000);

        // Verify item in cart then proceed to checkout via Cart page
        Assert.assertTrue(cartPage.getCartItemCount() >= 1, "Cart should have at least 1 item");
        cartPage.proceedToCheckout();
        Thread.sleep(1000);

        checkOutPage.fillInformation("shorooq", "elawi", "12345");
        checkOutPage.continueCheckout();
        Thread.sleep(1000);

        // Assert exact total is 29.99 before finishing
        String totalText = checkOutPage.getSummaryTotalText(); // e.g., "Total: $29.99"
        double total = Double.parseDouble(totalText.replaceAll("[^0-9.]", ""));
        Assert.assertEquals(total, 32.39, 0.01, "Expected total to be 32.39");

        checkOutPage.finishCheckout();
        Thread.sleep(2000);

        Assert.assertEquals(checkOutPage.getCompleteHeaderText(), "Thank you for your order!");

        checkOutPage.backToProducts();
        Thread.sleep(1000);
    }

@Test
    public void getJSONValue() throws InterruptedException{

    String URL=JSONReader.getValue("config.json", "URL");

    System.out.println("Read from json: "+ URL );

    }

    String username=JSONReader.getNestedValue("testdata.json", "login","username");
    String password=JSONReader.getNestedValue("testdata.json", "login","password");


    @Test
    public void loginwithTest() {

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                { "standard_user", "secret_sauce" },
                { "locked_out_user", "secret_sauce" },
                { "problem_user", "secret_sauce" },
                { "performance_glitch_user", "secret_sauce" }
        };
    }


    @Test(dataProvider ="getData" )
    public void loginttest(String username, String password){
        System.out.println("Login in with: ");
        System.out.println("username"+ username);
        System.out.println("password"+ password);
        System.out.println("----------------");
    }

    @Test(dataProvider = "getData")
    public void loginWithValidData(String username, String password) {
        Loginelment.Login(username, password);
        Assert.assertEquals(Product.LogoGetText(), "Swag Labs");
    }


@Test
    public void scrollToLinkedin(){
    Loginelment = new Login_2(driver);
    Product = new Product(driver);

    Loginelment.Login("problem_user", "secret_sauce");
    scrollToElement(Product.linkedin);

}

}


