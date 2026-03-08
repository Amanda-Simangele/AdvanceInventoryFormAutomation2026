package Base;

import Pages.HomePage;
import Pages.LearningMaterialPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import Utilities.BrowserFactory;
import Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class BaseTest  {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected LearningMaterialPage learningMaterialPage;
    protected WelcomePage welcomePage;


    @BeforeClass
    public void startBrowser(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.SetupDriver(ConfigReader.get("browser"));
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
