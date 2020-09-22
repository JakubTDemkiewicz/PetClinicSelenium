package pages;

import driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
