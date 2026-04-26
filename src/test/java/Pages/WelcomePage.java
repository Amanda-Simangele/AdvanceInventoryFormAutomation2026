package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }

    public String getWelcomeBackMessage(){
        return wait.until(ExpectedConditions.visibilityOf(welcomeBackMessage)).getText();
    }

    public void clickLearnButton(){
        wait.until(ExpectedConditions.elementToBeClickable(learnButton)).click();
    }

    public void  clickLearningMaterialsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsButton)).click();
    }

}
