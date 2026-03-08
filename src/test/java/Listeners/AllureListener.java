package Listeners;

import Base.BaseTest;
import Utilities.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {

        //This listener triggers whenever a test fails.
    //When a test fails: Selenium captures the screenshot, Allure attaches it to the report
        @Override
        public void onTestFailure(ITestResult result) {

            Object testClass = result.getInstance();

            WebDriver driver = ((BaseTest) testClass).getDriver();

            byte[] screenshot = ScreenshotUtil.takeScreenshot(driver);

            Allure.addAttachment(
                    "Screenshot on Failure",
                    new ByteArrayInputStream(screenshot)
            );
        }
}
