package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearningMaterialPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h3[normalize-space()='API Testing Practice']")
    WebElement aPItestingPracticeTitle;

    @FindBy(xpath = "//button[@id='tab-btn-web']")
    WebElement webTabButton;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(id = "storage-128GB")
    WebElement storage128GBRadioButton;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "subtotal-value")
    WebElement subtotalLabel;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    @FindBy(id = "shipping-express")
    WebElement expressShippingRadioButton;

    @FindBy(id = "breakdown-shipping-value")
    WebElement shippingCostLabel;

    @FindBy(id = "warranty-option-1yr")
    WebElement warranty1YearRadioButton;

    @FindBy(id = "breakdown-warranty-value")
    WebElement warrantyCostLabel;

    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    @FindBy(id = "breakdown-discount-value")
    WebElement discountValueLabel;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseButton;

    @FindBy(xpath = "//h4[@style=\"color: rgb(22, 163, 74); margin: 0px;\"]")
    WebElement orderConfirmationMessage;

    @FindBy(id = "view-history-btn")
    WebElement viewInvoiceButton;

    @FindBy(xpath = "//button[contains(@id,'view-invoice-')]")
    WebElement viewPDFButton;


    public LearningMaterialPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    //method to get the API Testing Practice title text
    public String getAPItestingPracticeTitle() {
        return wait.until(ExpectedConditions.visibilityOf(aPItestingPracticeTitle)).getText();
    }

    //method to click on the Web automation advance tab button to view the form
    public void clickWebTabButton() {
        wait.until(ExpectedConditions.elementToBeClickable(webTabButton)).click();
    }

    //method to select device type by visible text
    public void selectDeviceType(String deviceType) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(deviceTypeDropdown)));
        select.selectByVisibleText(deviceType);
    }

    //method to select brand by visible text
    public void selectBrand(String brand) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(brandDropdown)));
        select.selectByVisibleText(brand);
    }

    //method to select storage option by clicking on the 128GB radio button
    public void selectStorage128GB() {
        wait.until(ExpectedConditions.elementToBeClickable(storage128GBRadioButton)).click();
    }

    //method to select color by visible text
    public void SelectColor(String color) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(colorDropdown)));
        select.selectByVisibleText(color);
    }

    //method to select quantity by sending arrow up key twice
    public void selectQuantity() {
        WebElement quantities = wait.until(ExpectedConditions.visibilityOf(quantityInput));
        for (int i = 0; i < 2; i++) {
            quantities.sendKeys(Keys.ARROW_UP);
        }
    }

    //method to get the subtotal label text
    public String getSubtotalLabel() {
        return wait.until(ExpectedConditions.visibilityOf(subtotalLabel)).getText();

    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressInput)).sendKeys(address);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void clickExpressShipping() {
        wait.until(ExpectedConditions.elementToBeClickable(expressShippingRadioButton)).click();
    }

    public String verifyShippingCostLabel() {
        return wait.until(ExpectedConditions.visibilityOf(shippingCostLabel)).getText();
    }

    public void clickWarranty1Year() {
        wait.until(ExpectedConditions.elementToBeClickable(warranty1YearRadioButton)).click();
    }

    public String verifyWarrantyCostLabel() {
        return wait.until(ExpectedConditions.visibilityOf(warrantyCostLabel)).getText();
    }

    public void enterDiscountCode(String discountCode) {
        wait.until(ExpectedConditions.visibilityOf(discountCodeInput)).sendKeys(discountCode);
    }

    public void clickApplyDiscount() {
        wait.until(ExpectedConditions.elementToBeClickable(applyDiscountButton)).click();
    }

    public String getDiscountValueLabel() {
        return wait.until(ExpectedConditions.visibilityOf(discountValueLabel)).getText();
    }

    public void clickPurchaseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }

    public String getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(orderConfirmationMessage)).getText();
    }

    public void clickViewInvoiceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewInvoiceButton)).click();
    }

    public void clickInvoicePDFButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewPDFButton)).click();
    }


}
