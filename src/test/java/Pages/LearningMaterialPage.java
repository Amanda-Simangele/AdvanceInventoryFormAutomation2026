package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ElementUtil;

public class LearningMaterialPage {

    WebDriver driver;
    WebDriverWait wait;
    ElementUtil util;

    By aPItestingPracticeTitle = By.xpath("//h3[normalize-space()='API Testing Practice']");

    By webTabButton = By.xpath("//button[@id='tab-btn-web']");

    By deviceTypeDropdown = By.id("deviceType");

    By brandDropdown = By.id("brand");

    By storage128GBRadioButton = By.id("storage-128GB");

    By colorDropdown = By.id("color");

    By quantityInput = By.id("quantity");

    By subtotalLabel = By.id("subtotal-value");

    By addressInput = By.id("address");

    By nextButton = By.id("inventory-next-btn");

    By expressShippingRadioButton = By.id("shipping-express");

    By shippingCostLabel = By.id("breakdown-shipping-value");

    By warranty1YearRadioButton = By.id("warranty-option-1yr");

    By warrantyCostLabel = By.id("breakdown-warranty-value");

    By discountCodeInput = By.id("discount-code");

    By applyDiscountButton = By.id("apply-discount-btn");

    By discountValueLabel = By.id("breakdown-discount-value");

    By purchaseButton = By.id("purchase-device-btn");

    By orderConfirmationMessage = By.xpath("//h4[@style=\"color: rgb(22, 163, 74); margin: 0px;\"]");

    By viewInvoiceButton = By.id("view-history-btn");

    By viewPDFButton = By.xpath("//button[contains(@id,'view-invoice-')]");


    public LearningMaterialPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        this.util = new ElementUtil(driver);

    }

    //method to get the API Testing Practice title text
    public String getAPItestingPracticeTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(aPItestingPracticeTitle)).getText();
    }

    //method to click on the Web automation advance tab button to view the form
    public void clickWebTabButton() {
        util.click(webTabButton);
    }

    //method to select device type by visible text
    public void selectDeviceType(String deviceType) {
        WebElement selectEl = wait.until(ExpectedConditions.visibilityOfElementLocated(deviceTypeDropdown));
        Select select = new Select(selectEl);
        select.selectByVisibleText(deviceType);
    }

    //method to select brand by visible text
    public void selectBrand(String brand) {
        WebElement selectEl = wait.until(ExpectedConditions.visibilityOfElementLocated(brandDropdown));
        Select select = new Select(selectEl);
        select.selectByVisibleText(brand);
    }

    //method to select storage option by clicking on the 128GB radio button
    public void selectStorage128GB() {
        util.click(storage128GBRadioButton);
    }

    //method to select color by visible text
    public void SelectColor(String color) {
        WebElement selectEl = wait.until(ExpectedConditions.visibilityOfElementLocated(colorDropdown));
        Select select = new Select(selectEl);
        select.selectByVisibleText(color);
    }

    //method to select quantity by sending arrow up key twice
    public void selectQuantity() {
        WebElement quantities = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        for (int i = 0; i < 2; i++) {
            quantities.sendKeys(Keys.ARROW_UP);
        }
    }

    //method to get the subtotal label text
    public String getSubtotalLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalLabel)).getText();

    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressInput)).sendKeys(address);
    }

    public void clickNextButton() {
        util.click(nextButton);
    }

    public void clickExpressShipping() {
        util.click(expressShippingRadioButton);
    }

    public String verifyShippingCostLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingCostLabel)).getText();
    }

    public void clickWarranty1Year() {
        util.click(warranty1YearRadioButton);
    }

    public String getWarrantyCostLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(warrantyCostLabel)).getText();
    }

    public void enterDiscountCode(String discountCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountCodeInput)).sendKeys(discountCode);
    }

    public void clickApplyDiscount() {
        util.click(applyDiscountButton);
    }

    public String getDiscountValueLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(discountValueLabel)).getText();
    }

    public void clickPurchaseButton() {
        util.click(purchaseButton);
    }

    public String getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).getText();
    }

    public void clickViewInvoiceButton() {
        util.click(viewInvoiceButton);
    }

    public void clickInvoicePDFButton() {
        util.click(viewPDFButton);
    }


}
