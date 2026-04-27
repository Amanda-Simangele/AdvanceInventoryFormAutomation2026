package Pages;


import Utilities.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ElementUtil;

import javax.swing.text.Utilities;
import java.io.ByteArrayInputStream;

import static Utilities.ScreenshotUtil.takeScreenshot;

public class WelcomePage {
    WebDriver driver;
    WebDriverWait wait;
    ElementUtil util;

    By learnButton = By.xpath("//button[.//span[text()='Learn']]");

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
        util.click(learnButton);
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
