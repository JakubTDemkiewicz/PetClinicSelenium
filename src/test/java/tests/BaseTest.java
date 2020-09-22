package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static navigation.ApplicationUrls.APPLICATION_URL;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        driver = DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterClass
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
