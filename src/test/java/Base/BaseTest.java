package Base;

import Pages.HomePage;
import Pages.LearningMaterialPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver = browserFactory.SetupDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        learningMaterialPage = new LearningMaterialPage(driver);
        welcomePage = new WelcomePage(driver);


    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
