package Pages;

import Utilities.TestBase_1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut extends TestBase_1 {

    public CheckOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(css = ".summary_subtotal_label")
    WebElement summarySubtotalLabel;

    @FindBy(css = ".summary_tax_label")
    WebElement summaryTaxLabel;

    @FindBy(css = ".summary_total_label")
    WebElement summaryTotalLabel;

    @FindBy(className = "complete-header")
    WebElement completeHeader;

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public void startCheckout() {
        checkoutButton.click();
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.clear();
        sendKey(firstNameInput,firstName);
        lastNameInput.clear();
        sendKey(lastNameInput,lastName);
        postalCodeInput.clear();
        sendKey(postalCodeInput,postalCode);
    }

    public void continueCheckout() {
        click(continueButton);
    }

    public void cancelCheckout() {
        click(cancelButton);
    }

    public void finishCheckout() {
        click(finishButton);
    }

    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getSummarySubtotalText() {
        return summarySubtotalLabel.getText();
    }

    public String getSummaryTaxText() {
        return summaryTaxLabel.getText();
    }

    public String getSummaryTotalText() {
        return summaryTotalLabel.getText();
    }

    public String getCompleteHeaderText() {
        return completeHeader.getText();
    }

    public void backToProducts() {
        click(backHomeButton);
    }
}