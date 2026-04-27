package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ElementUtil;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    ElementUtil util;

    By usernameField = By.id("login-email");

    By passwordField = By.id("login-password");

    By loginButton = By.id("login-submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        this.util = new ElementUtil(driver);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        util.click(loginButton);
    }

}
