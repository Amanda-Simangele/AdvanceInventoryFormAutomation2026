package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class ElementUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // 🔥 MAIN CLICK METHOD (use this everywhere)
    public void click(By locator) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(locator)
            );

            scrollToElement(element);

            // try normal click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            } catch (Exception e) {
                // fallback to JS click
                jsClick(element);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to click element: " + locator, e);
        }
    }

    // 🔁 Retry click (for flaky elements)
    public void clickWithRetry(By locator, int attempts) {
        for (int i = 0; i < attempts; i++) {
            try {
                click(locator);
                return;
            } catch (Exception e) {
                sleep(1000);
            }
        }
        throw new RuntimeException("Element not clickable after retries: " + locator);
    }

    // 📜 Scroll
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    // ⚡ JS click
    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // 🖱 Hover (for dropdowns if needed)
    public void hover(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        new Actions(driver).moveToElement(element).perform();
    }

    // ⏱ small sleep helper
    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    // 📸 Simple screenshot helper — writes PNG to target/screenshots and returns the absolute path
    public String takeScreenshot(String namePrefix) {
        try {
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String ts = DateTimeFormatter.ISO_INSTANT.format(Instant.now()).replace(':','-');
            String fileName = String.format("%s_%s.png", namePrefix, ts);
            Path outDir = Paths.get("target", "screenshots");
            if (!Files.exists(outDir)) {
                Files.createDirectories(outDir);
            }
            Path out = outDir.resolve(fileName);
            Files.write(out, bytes);
            return out.toAbsolutePath().toString();
        } catch (WebDriverException | IOException e) {
            // don't fail the test solely because screenshot failed — return null
            return null;
        }
    }

}
