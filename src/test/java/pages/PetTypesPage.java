package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.Methods.getBackgroundColorOfElements;

public class PetTypesPage extends BasePage {
    @FindBy(css = "[name='pettype_name']")
    private List<WebElement> petTypesList;

    public List<String> getPetTypesBackgroundColours() {
        return getBackgroundColorOfElements(petTypesList);
    }

}
