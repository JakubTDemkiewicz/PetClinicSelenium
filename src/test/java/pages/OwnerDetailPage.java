package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.List;

import static helpers.Methods.*;

public class OwnerDetailPage extends BasePage {
    @FindBy(css = "div > table:nth-child(2) tr:nth-child(1) td b")
    private WebElement fullNameText;

    @FindBy(css = "div > table:nth-child(2) tr:nth-child(2) td")
    private WebElement addressText;

    @FindBy(css = "div > table:nth-child(2) tr:nth-child(3) td")
    private WebElement cityText;

    @FindBy(css = "div > table:nth-child(2) tr:nth-child(4) td")
    private WebElement telephoneText;

    @FindBy(xpath = "//*[text() = 'Add New Pet']")
    private WebElement addPetButton;

    @FindBy(xpath = "//*[text()= 'Add Visit']")
    private WebElement addVisitButton;

    @FindBy(css = "app-visit-list > table > tbody > tr > td:nth-child(1)")
    private WebElement visitDateText;

    @FindBy(css = "app-visit-list > table > tbody > tr > td:nth-child(2)")
    private WebElement descriptionVisitText;

    @FindBy(css = "dd:nth-child(2)")
    private WebElement petNameText;

    @FindBy(css = "dd:nth-child(4)")
    private WebElement birthPetText;

    @FindBy(css = "dd:nth-child(6)")
    private WebElement petTypeText;

    @FindBy(className = "btn-default")
    private List<WebElement> buttons;


    public String getFullNameText() {
        WaitForElement.waitForAngular();
//        WaitForElement.waitUntilElementIsVisible(fullNameText);
        return fullNameText.getText();
    }

    public String getAddressText() {
        return addressText.getText();
    }

    public String getCityText() {
        return cityText.getText();
    }

    public String getTelephoneText() {
        return telephoneText.getText();
    }

    public String getDescriptionVisitText() {
        return descriptionVisitText.getText();
    }

    public String getVisitDateText() {
        return visitDateText.getText();
    }

    public String getPetTypeText() {
        return petTypeText.getText();
    }

    public String getPetNameText() {
        return petNameText.getText();
    }

    public String getBirthPetText() {
        return birthPetText.getText();
    }

    public void clickAddNewPet() {
        WaitForElement.waitUntilElementIsClickable(addPetButton);
        addPetButton.click();
    }

    public void clickAddVisitButton() {
        WaitForElement.waitUntilElementIsClickable(addVisitButton);
        addVisitButton.click();
    }

    public void takeOwnersDetailsPageScreenshot() {
        takeScreenShot(getClass().getName(), fullNameText);
    }

    public String getFontWeightForFullName() {
        WaitForElement.waitUntilElementIsVisible(fullNameText);
        return fullNameText.getCssValue("font-weight");
    }

    public List<String> getButtonsBorderBottomColor() {
        return getBorderBottomColorOfElements(buttons);
    }

    public List<String> getButtonsBackgroundColor() {
        return getBackgroundColorOfElements(buttons);
    }
}
