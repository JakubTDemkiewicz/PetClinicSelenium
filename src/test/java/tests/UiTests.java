package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import pages.OwnerDetailPage;
import pages.PetTypesPage;
import pages.SpecialtiesPage;

import java.util.List;

import static navigation.ApplicationUrls.*;
import static org.testng.Assert.assertTrue;


public class UiTests extends BaseTest {
    private static final String GREY_BACKGROUND = "#eeeeee";

    @Test
    public void validatePetTypesBackground() {
        List<String> colors;
        DriverUtils.navigateToPage(PET_TYPES_URL);

        PetTypesPage petTypesPage = new PetTypesPage();
        colors = petTypesPage.getPetTypesBackgroundColours();
        System.out.println(colors.toString());
        assertColours(colors, GREY_BACKGROUND);
    }

    @Test
    public void validateSpecialtiesBackground() {
        List<String> colors;
        DriverUtils.navigateToPage(SPECIALTIES_URL);

        SpecialtiesPage specialtiesPage = new SpecialtiesPage();
        colors = specialtiesPage.getSpecialtiesBackgroundColour();
        assertColours(colors, GREY_BACKGROUND);
    }

    @Test()
    public void validateOwnerProfileUI() {
        DriverUtils.navigateToPage(FIRST_OWNER_URL);
        OwnerDetailPage ownerDetailPage = new OwnerDetailPage();

        String fontWeight = ownerDetailPage.getFontWeightForFullName();
        List<String> buttonsBorderColor = ownerDetailPage.getButtonsBorderBottomColor();
        List<String> buttonsBackgroundColor = ownerDetailPage.getButtonsBackgroundColor();

        ownerDetailPage.takeOwnersDetailsPageScreenshot();
        assertTrue(fontWeight.equals("bold") || fontWeight.equals("700"));
        assertColours(buttonsBackgroundColor, "#34302d");
        assertColours(buttonsBorderColor, "#6db33f");
    }

    private void assertColours(List<String> list, String colour) {
        for (String element : list) {
            assertTrue(element.equals(colour));
        }
    }
}
