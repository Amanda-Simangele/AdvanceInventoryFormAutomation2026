package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver setupDriver(String browser) {

        if (browser == null || browser.isEmpty()) {
            browser = "chrome"; // default
        }

        switch (browser.toLowerCase()) {

            case "chrome":
                return createChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        boolean isCI = System.getenv("CI") != null;

        if (isCI) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        // ✅ THIS LINE FIXES EVERYTHING
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver(options);
    }
}