package Tests;

import Base.BaseTest;
import Utilities.ReadXLSData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulPurchase extends BaseTest {

    @Test(groups = {"smoke"})
    public void verifyLoginPageTitle() {
        Assert.assertEquals(homePage.getWelcomeMessage(),"Master Test Automation");
        homePage.clickLoginButton();
    }

    @Test(dependsOnMethods = "verifyLoginPageTitle", dataProviderClass = ReadXLSData.class, dataProvider = "testData",
            groups = {"smoke"})
    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "login", groups = {"smoke"})
    public void clickLearn() {
        Assert.assertEquals(welcomePage.getWelcomeBackMessage(), "Here's an overview of your learning journey");
        welcomePage.clickLearnButton();
        welcomePage.clickLearningMaterialsButton();

    }

    @Test(dependsOnMethods = "clickLearn", groups = {"smoke"})
    public void verifyLearningMaterialsPage() {
        Assert.assertEquals(learningMaterialPage.getAPItestingPracticeTitle(), "API Testing Practice");
    }

    @Test(dependsOnMethods = "verifyLearningMaterialsPage", groups = {"regression"})
    public void clickWebTab() {
        learningMaterialPage.clickWebTabButton();
    }

    @Test(dependsOnMethods = "clickWebTab", groups = {"regression"})
    public void selectDeviceType() {
        learningMaterialPage.selectDeviceType("Phone");
    }
    //add a method to verify brand is enabled after selecting device type

    @Test(dependsOnMethods = "selectDeviceType", groups = {"regression"})
    public void selectBrand() {
        learningMaterialPage.selectBrand("Apple");
    }
    @Test(dependsOnMethods = "selectBrand", groups = {"regression"})
    public void selectStorage() {
        learningMaterialPage.selectStorage128GB();
    }
    @Test(dependsOnMethods = "selectStorage", groups = {"regression"})
    public void selectColor() {
        learningMaterialPage.SelectColor("Blue");
    }
    @Test(dependsOnMethods = "selectColor", groups = {"regression"})
    public void enterQuantity() throws InterruptedException {
        learningMaterialPage.selectQuantity();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "enterQuantity", groups = {"regression"})
    public void verifySubtotal(){
        Assert.assertEquals(learningMaterialPage.getSubtotalLabel(), "R960.00");
    }

    @Test(dependsOnMethods = "verifySubtotal", groups = {"regression"})
    public void enterAddress(){
        learningMaterialPage.enterAddress("123 Test Street");
    }

    @Test(dependsOnMethods = "enterAddress", groups = {"regression"})
    public void clickNext() {
        learningMaterialPage.clickNextButton();
    }

     @Test(dependsOnMethods = "clickNext", groups = {"regression"})
     public void clickExpressShipping() {
         learningMaterialPage.clickExpressShipping();
     }

    @Test(dependsOnMethods = "clickExpressShipping", groups = {"regression"})
    public void verifyShippingCost() {
        Assert.assertEquals(learningMaterialPage.verifyShippingCostLabel(), "R25.00");
    }

     @Test(dependsOnMethods = "verifyShippingCost", groups = {"regression"})
        public void clickWarranty() {
            learningMaterialPage.clickWarranty1Year();
     }

     @Test(dependsOnMethods = "clickWarranty", groups = {"regression"})
     public void verifyWarrantyCost() {
         Assert.assertEquals(learningMaterialPage.getWarrantyCostLabel(), "R49.00");
     }

     @Test(dependsOnMethods = "verifyWarrantyCost", groups = {"regression"})
        public void clickNextButton() {
            learningMaterialPage.enterDiscountCode("SAVE10");
     }

     @Test(dependsOnMethods = "clickNextButton", groups = {"regression"})
        public void clickApplyDiscount() {
            learningMaterialPage.clickApplyDiscount();
     }

     @Test(dependsOnMethods = "clickApplyDiscount", groups = {"regression"})
        public void verifyOrderSummary() {
            Assert.assertEquals(learningMaterialPage.getDiscountValueLabel(), "- R103.40");
     }
        @Test(dependsOnMethods = "verifyOrderSummary", groups = {"regression"})
            public void clickPurchase() {
                learningMaterialPage.clickPurchaseButton();
        }

        @Test(dependsOnMethods = "clickPurchase", groups = {"regression"})
        public void verifyOrderConfirmation() {
                Assert.assertEquals(learningMaterialPage.getOrderConfirmationMessage(), "ORDER SUCCESSFUL! \uD83C\uDF89");
        }
        @Test(dependsOnMethods = "verifyOrderConfirmation", groups = {"regression"})
        public void clickViewInvoice() throws InterruptedException {
            Thread.sleep(2000);
            learningMaterialPage.clickViewInvoiceButton();
        }
        @Test(dependsOnMethods = "clickViewInvoice", groups = {"regression"})
        public void clickInvoice() throws InterruptedException {
            Thread.sleep(2000);
            learningMaterialPage.clickInvoicePDFButton();
        }




}
