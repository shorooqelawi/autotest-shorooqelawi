package Pages;

import Utilities.TestBase_1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Product extends TestBase_1 {

    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Header/logo
    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @FindBy(xpath = "//a[@data-test='social-linkedin']")
    public WebElement linkedin;

    @FindBy(css = "span.title")
    WebElement pageTitle;

    // Burger menu and logout
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    // Cart
    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    WebElement cartBadge;

    // Sort dropdown
    @FindBy(id = "product_sort_container")
    WebElement sortDropdown;

    // Sample product buttons (Sauce Labs Backpack)
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpackButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackButton;

    // Lists of items and names
    @FindBy(css = ".inventory_item")
    List<WebElement> inventoryItems;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> itemNames;

    // Exposed methods (keep naming similar to Login_2 style)
    public String LogoGetText() {
        return appLogo.getText();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void openMenu() {
        click(menuButton);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void openCart() {
        click(cartLink);
    }

    public void addBackpackToCart() {
        click(addBackpackButton);
    }

    public void removeBackpackFromCart() {
        click(removeBackpackButton);
    }

    public int getCartBadgeCount() {
        try {
            if (cartBadge.isDisplayed()) {
                return Integer.parseInt(cartBadge.getText().trim());
            }
        } catch (Exception ignore) { }
        return 0;
    }

    public void selectSortByVisibleText(String visibleText) {
        new Select(sortDropdown).selectByVisibleText(visibleText);
    }

    public String getFirstItemName() {
        return (itemNames != null && !itemNames.isEmpty()) ? itemNames.get(0).getText() : "";
    }

    public void addProductToCart(){

    }
    public void clickLinkedin(){
        click(linkedin);
    }
}
