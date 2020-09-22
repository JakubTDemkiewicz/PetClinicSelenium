package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AllOwnersPage extends BasePage {
    @FindBy(css = "table tr:last-child td:first-child")
    private WebElement lastTableElement;

    public void clickOnLastCreatedElement() {
        WaitForElement.waitForClickableFluentWait(lastTableElement);
        lastTableElement.click();
    }

    public String getLastCreatedOwnerText() {
        WaitForElement.waitUntilElementIsVisible(lastTableElement);
        return lastTableElement.getText();
    }
}
