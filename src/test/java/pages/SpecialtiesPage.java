package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.Methods.getBackgroundColorOfElements;

public class SpecialtiesPage extends BasePage {
    @FindBy(css = "[name='spec_name']")
    private List<WebElement> specialtiesList;

    public List<String> getSpecialtiesBackgroundColour() {
        return getBackgroundColorOfElements(specialtiesList);
    }
}
