package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void login() {
        Assert.assertEquals(homePage.getWelcomeMessage(),"Master Test Automation");
        homePage.clickLoginButton();
        loginPage.enterUsername("Amy@123.com");
        loginPage.enterPassword("Amy@123456");
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
        Assert.assertEquals(learningMaterialPage.verifySubtotalLabel(), "R960.00");
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



}
