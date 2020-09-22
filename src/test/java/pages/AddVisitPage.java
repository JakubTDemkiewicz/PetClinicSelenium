package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AddVisitPage extends BasePage {
    @FindBy(xpath = "//input[@name='date']")
    private WebElement visitDateInput;

    @FindBy(id = "description")
    private WebElement descriptionInput;

    @FindBy(xpath = "//*[text()='Add Visit']")
    private WebElement addVisitButton;

    public void createVisit(String date, String description) {
        WaitForElement.waitUntilElementIsVisible(visitDateInput);
        visitDateInput.sendKeys(date);
        descriptionInput.sendKeys(description);
        addVisitButton.click();
    }

}
