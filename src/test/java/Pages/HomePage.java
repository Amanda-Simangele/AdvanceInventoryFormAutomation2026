package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(@class,'hero-title')]")
    WebElement welcomeMessage;

    @FindBy(xpath = "//button[contains(@class,'user-pill')]")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }

    //method to get the welcome message text
    public String getWelcomeMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[contains(@class,'hero-title')]")
        ));

        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).getText();
    }

    // method to click on the login button
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }


}
