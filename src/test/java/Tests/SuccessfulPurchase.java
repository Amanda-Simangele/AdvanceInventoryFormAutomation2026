package Tests;

import Base.BaseTest;
import Utilities.ReadXLSData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulPurchase extends BaseTest {

    @Test
    public void verifyLoginPageTitle() {
        Assert.assertEquals(homePage.getWelcomeMessage(),"Master Test Automation");
        homePage.clickLoginButton();
    }

    @Test (dependsOnMethods = "verifyLoginPageTitle" , dataProviderClass = ReadXLSData.class, dataProvider = "testData" )
    public void login( String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
    @Test(dependsOnMethods = "login")
    public void clickLearn() {
        Assert.assertEquals(welcomePage.getWelcomeBackMessage(), "Here's an overview of your learning journey");
        welcomePage.clickLearnButton();
        welcomePage.clickLearningMaterialsButton();

    }
    @Test(dependsOnMethods = "clickLearn")
    public void verifyLearningMaterialsPage() {
        Assert.assertEquals(learningMaterialPage.getAPItestingPracticeTitle(), "API Testing Practice");
    }
    @Test(dependsOnMethods = "verifyLearningMaterialsPage")
    public void clickWebTab() {
        learningMaterialPage.clickWebTabButton();
    }
    @Test(dependsOnMethods = "clickWebTab")
    public void selectDeviceType() {
        learningMaterialPage.selectDeviceType("Phone");
    }
    //add a method to verify brand is enabled after selecting device type

    @Test(dependsOnMethods = "selectDeviceType")
    public void selectBrand() {
        learningMaterialPage.selectBrand("Apple");
    }
    @Test(dependsOnMethods = "selectBrand")
    public void selectStorage() {
        learningMaterialPage.selectStorage128GB();
    }
    @Test(dependsOnMethods = "selectStorage")
    public void selectColor() {
        learningMaterialPage.SelectColor("Blue");
    }
    @Test(dependsOnMethods = "selectColor")
    public void enterQuantity() throws InterruptedException {
        learningMaterialPage.selectQuantity();
        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = "enterQuantity")
    public void verifySubtotal(){
        Assert.assertEquals(learningMaterialPage.getSubtotalLabel(), "R960.00");
    }

    @Test (dependsOnMethods = "verifySubtotal")
    public void enterAddress(){
        learningMaterialPage.enterAddress("123 Test Street");
    }

    @Test (dependsOnMethods = "enterAddress")
    public void clickNext() {
        learningMaterialPage.clickNextButton();
    }

     @Test (dependsOnMethods = "clickNext")
     public void clickExpressShipping() {
         learningMaterialPage.clickExpressShipping();
     }

    @Test(dependsOnMethods = "clickExpressShipping")
    public void verifyShippingCost() {
        Assert.assertEquals(learningMaterialPage.verifyShippingCostLabel(), "R25.00");
    }

     @Test(dependsOnMethods = "verifyShippingCost")
        public void clickWarranty() {
            learningMaterialPage.clickWarranty1Year();
     }

     @Test (dependsOnMethods = "clickWarranty")
     public void verifyWarrantyCost() {
         Assert.assertEquals(learningMaterialPage.getWarrantyCostLabel(), "R49.00");
     }

     @Test (dependsOnMethods = "verifyWarrantyCost")
        public void clickNextButton() {
            learningMaterialPage.enterDiscountCode("SAVE10");
     }

     @Test (dependsOnMethods = "clickNextButton")
        public void clickApplyDiscount() {
            learningMaterialPage.clickApplyDiscount();
     }

     @Test (dependsOnMethods = "clickApplyDiscount")
        public void verifyOrderSummary() {
            Assert.assertEquals(learningMaterialPage.getDiscountValueLabel(), "- R103.40");
     }
        @Test (dependsOnMethods = "verifyOrderSummary")
            public void clickPurchase() {
                learningMaterialPage.clickPurchaseButton();
        }

        @Test(dependsOnMethods = "clickPurchase")
        public void verifyOrderConfirmation() {
                Assert.assertEquals(learningMaterialPage.getOrderConfirmationMessage(), "ORDER SUCCESSFUL! \uD83C\uDF89");
        }
        @Test(dependsOnMethods = "verifyOrderConfirmation")
        public void clickViewInvoice() throws InterruptedException {
            Thread.sleep(2000);
            learningMaterialPage.clickViewInvoiceButton();
        }
        @Test(dependsOnMethods = "clickViewInvoice")
        public void clickInvoice() throws InterruptedException {
            Thread.sleep(2000);
            learningMaterialPage.clickInvoicePDFButton();
        }





}
