package Pages;


import Utilities.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

import static Utilities.ScreenshotUtil.takeScreenshot;

public class WelcomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//button[.//span[normalize-space()='Learn']]")
    WebElement learnButton;

    @FindBy (xpath = "//p[normalize-space()=\"Here's an overview of your learning journey\"]")
    WebElement welcomeBackMessage;

    @FindBy (xpath = "//button[.//span[normalize-space()='Learning Materials']]")
    WebElement learningMaterialsButton;


    public  WelcomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);

    }

    public String getWelcomeBackMessage(){

        return wait.until(ExpectedConditions.visibilityOf(welcomeBackMessage)).getText();
    }

    public void clickLearnButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(learnButton));
            wait.until(ExpectedConditions.elementToBeClickable(learnButton)).click();

        } catch (Exception e) {

            // ✅ TAKE screenshot using your util
            byte[] screenshot = ScreenshotUtil.takeScreenshot(driver);

            // ✅ ATTACH to Allure
            Allure.addAttachment("clickLearnButton",
                    new ByteArrayInputStream(screenshot));

            throw e;
        }
    }

    public void  clickLearningMaterialsButton(){
        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(learningMaterialsButton)
        ));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        element.click();
    }

}
