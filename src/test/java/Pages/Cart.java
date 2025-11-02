package Pages;

import Utilities.TestBase_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class Cart extends TestBase_1 {

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item")
    List<WebElement> cartItems;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> itemNames;

    @FindBy(css = "button[id^='remove-']")
    List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public int getCartItemCount() {
        return cartItems != null ? cartItems.size() : 0;
    }

    public List<String> getAllItemNames() {
        List<String> names = new ArrayList<>();
        if (itemNames != null) {
            for (WebElement e : itemNames) names.add(e.getText());
        }
        return names;
    }

    public String getFirstItemName() {
        return (itemNames != null && !itemNames.isEmpty()) ? itemNames.get(0).getText() : "";
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }

    public void removeFirstItem() {
        if (cartItems != null && !cartItems.isEmpty()) {
            WebElement first = cartItems.get(0);
            first.findElement(By.cssSelector("button[id^='remove-']")).click();
        }
    }

    public boolean removeItemByName(String name) {
        if (cartItems == null) return false;
        for (WebElement item : cartItems) {
            String itemName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (itemName.equalsIgnoreCase(name)) {
                item.findElement(By.cssSelector("button[id^='remove-']")).click();
                return true;
            }
        }
        return false;
    }
}
