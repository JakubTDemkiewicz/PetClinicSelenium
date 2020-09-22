package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AddNewOwnerPage extends BasePage {
    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "telephone")
    private WebElement telephoneInput;

    @FindBy(css = "[type=submit]")
    private WebElement addOwnerButton;

    public void createOwner(String firstName, String lastName, String address, String city, String telephone) {
        WaitForElement.waitUntilElementIsVisible(firstNameInput);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        telephoneInput.sendKeys(telephone);
        addOwnerButton.click();
    }
}
