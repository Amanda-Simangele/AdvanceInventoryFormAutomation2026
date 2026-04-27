package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ElementUtil;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    ElementUtil util;

    By welcomeMessage = By.xpath("//h1[contains(@class,'hero-title')]");

    By loginButton = By.xpath("//button[contains(@class,'user-pill')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        this.util = new ElementUtil(driver);

    }

    //method to get the welcome message text
    public String getWelcomeMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(welcomeMessage));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).getText();
    }

    // method to click on the login button
    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));

        // use ElementUtil which does scroll + safe click (JS fallback)
        util.click(loginButton);
    }

}
