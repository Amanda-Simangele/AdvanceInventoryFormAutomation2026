package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ElementUtil;

public class WelcomePage {
    WebDriver driver;
    WebDriverWait wait;
    ElementUtil util;

    By learnButton = By.xpath("//button[.//span[text()='Learn']]");

    By welcomeBackMessage = By.xpath("//p[normalize-space()=\"Here's an overview of your learning journey\"]");

    By learningMaterialsButton = By.xpath("//button[.//span[normalize-space()='Learning Materials']]");


    public  WelcomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(40));
        this.util = new ElementUtil(driver);
        // removed PageFactory usage to prefer explicit By locators + ElementUtil
    }

    public String getWelcomeBackMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackMessage)).getText();
    }

    public void clickLearnButton() {
        util.click(learnButton);
    }

    @SuppressWarnings("unused")
    public void  clickLearningMaterialsButton(){
        // prefer ElementUtil.click which does waiting, scrolling and JS fallback
        util.click(learningMaterialsButton);
    }

}
