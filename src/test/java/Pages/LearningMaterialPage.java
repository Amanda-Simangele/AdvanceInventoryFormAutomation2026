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

    @FindBy( id="deviceType")
    WebElement deviceTypeDropdown;

    @FindBy (id="brand")
    WebElement brandDropdown;

    @FindBy ( id="storage-128GB")
    WebElement storage128GBRadioButton;

    @FindBy (id="color")
    WebElement colorDropdown;

    @FindBy (id="quantity")
    WebElement quantityInput;

    @FindBy(id="subtotal-value")
    WebElement subtotalLabel;

    @FindBy(id="address")
    WebElement addressInput;

    @FindBy (id="inventory-next-btn")
    WebElement nextButton;

    @FindBy (id="shipping-express")
    WebElement expressShippingRadioButton;


    public  LearningMaterialPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public String getAPItestingPracticeTitle(){
        return wait.until(ExpectedConditions.visibilityOf(aPItestingPracticeTitle)).getText();
    }

        public void clickWebTabButton(){
            wait.until(ExpectedConditions.elementToBeClickable(webTabButton)).click();
        }

        public void selectDeviceType(String deviceType){
            Select select = new Select(wait.until(ExpectedConditions.visibilityOf(deviceTypeDropdown)));
            select.selectByVisibleText(deviceType);
        }

        public void selectBrand(String brand){
            Select select = new Select(wait.until(ExpectedConditions.visibilityOf(brandDropdown)));
            select.selectByVisibleText(brand);
        }
        public void selectStorage128GB(){
            wait.until(ExpectedConditions.elementToBeClickable(storage128GBRadioButton)).click();
        }
        //method to select color by visible text
        public void SelectColor(String color){
            Select select = new Select(wait.until(ExpectedConditions.visibilityOf(colorDropdown)));
            select.selectByVisibleText(color);
        }

        //method to select quantity by sending arrow up key twice
        public void selectQuantity(){
            WebElement quantities = wait.until(ExpectedConditions.visibilityOf(quantityInput));
            for(int i=0; i<2; i++) {
                quantities.sendKeys(Keys.ARROW_UP);
            }
        }

        public String verifySubtotalLabel() {
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






}
