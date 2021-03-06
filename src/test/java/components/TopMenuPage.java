package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TopMenuPage extends BasePage {
    @FindBy(xpath = "//*[text() = 'Owners']")
    private WebElement ownersTopMenuButton;

    @FindBy(css = "a[href*='owners/add']")
    private WebElement addNewOwnerButton;

    @FindBy(css = "a[href*='petclinic/pettypes']")
    private WebElement petTypesButton;

    public void clickOnOwnersTabInNavBar() {
        ownersTopMenuButton.click();
    }

    public void clickAddNewOwner() {
        addNewOwnerButton.click();
    }

    public void clickOnPetTypes() {
        petTypesButton.click();
    }
}
