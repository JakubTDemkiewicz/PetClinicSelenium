package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

public class AddPetPage extends BasePage {
    @FindBy(id = "name")
    private WebElement petNameInput;

    @FindBy(css = "[name=birthDate]")
    private WebElement birthDateInput;

    @FindBy(css = "#type")
    private WebElement typeDropDown;

    @FindBy(css = "[type=submit]")
    private WebElement savePet;

    public void createNewPet(String name, String birthDate, String type) {
        WaitForElement.waitUntilElementIsVisible(petNameInput);
        petNameInput.sendKeys(name);
        birthDateInput.sendKeys(birthDate);
        Select select = new Select(typeDropDown);
        select.selectByVisibleText(type);
        WaitForElement.waitForClickableFluentWait(savePet);
        savePet.click();
    }
}
