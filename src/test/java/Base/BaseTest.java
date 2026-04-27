package Base;

import Pages.HomePage;
import Pages.LearningMaterialPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import Utilities.BrowserFactory;
import Utilities.ConfigReader;
import Utilities.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class BaseTest  {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected LearningMaterialPage learningMaterialPage;
    protected WelcomePage welcomePage;
    protected ElementUtil util;


    @BeforeClass
    public void startBrowser() {

        // ✅ Use static factory (no object creation)
        driver = BrowserFactory.setupDriver(ConfigReader.get("browser"));

        // ✅ Stability
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // initialize helper util
        util = new ElementUtil(driver);

        // ✅ Navigate after setup
        driver.get(ConfigReader.get("url"));

        // ✅ Initialize pages AFTER driver is ready
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        learningMaterialPage = new LearningMaterialPage(driver);
        welcomePage = new WelcomePage(driver);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Check @BeforeClass setup.");
        }
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void captureOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                String name = result.getMethod().getMethodName();
                String path = null;
                if (util != null) {
                    path = util.takeScreenshot("failure_" + name);
                } else if (driver != null) {
                    // fallback
                    path = new ElementUtil(driver).takeScreenshot("failure_" + name);
                }
                System.out.println("[TEST-DEBUG] Test failed: " + name);
                if (path != null) {
                    System.out.println("[TEST-DEBUG] Screenshot saved to: " + path);
                } else {
                    System.out.println("[TEST-DEBUG] Screenshot could not be captured.");
                }

                // Safe logging of environment credentials (masked) — only for debugging on CI
                printMaskedEnv("DB_URL");
                printMaskedEnv("DB_USERNAME");
                printMaskedEnv("DB_PASSWORD");

            } catch (Exception e) {
                // don't rethrow — we're in teardown
                System.out.println("[TEST-DEBUG] Error while capturing failure details: " + e.getMessage());
            }
        }
    }

    private void printMaskedEnv(String key) {
        String v = System.getenv(key);
        if (v == null || v.isEmpty()) {
            System.out.println("[TEST-DEBUG] Env " + key + " is not set.");
            return;
        }
        String masked = maskValue(v);
        System.out.println("[TEST-DEBUG] Env " + key + " (masked): " + masked);
    }

    private String maskValue(String v) {
        if (v.length() <= 4) return "****";
        String start = v.substring(0, 2);
        String end = v.substring(v.length() - 2);
        return start + "..." + end;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
