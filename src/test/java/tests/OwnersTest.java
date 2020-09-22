package tests;

import components.TopMenuPage;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OwnersTest extends BaseTest {
    private final String firstName = DataGenerator.randomString(7);
    private final String lastName = DataGenerator.randomString(7);
    private final String address = DataGenerator.randomString(10);
    private final String city = DataGenerator.randomString(6);
    private final String telephone = DataGenerator.randomInteger(9);
    private final String petName = DataGenerator.randomString(4);
    private final String currentDate = DataGenerator.currentDate();
    private final String descriptionText = DataGenerator.randomString(16);
    private final String petType = "dog";

    @Test
    public void createNewOwner() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnOwnersTabInNavBar();
        topMenuPage.clickAddNewOwner();

        AddNewOwnerPage addOwnerPage = new AddNewOwnerPage();
        addOwnerPage.createOwner(firstName, lastName, address, city, telephone);
        AllOwnersPage allOwnersPage = new AllOwnersPage();

        assertTrue(allOwnersPage.getLastCreatedOwnerText().contains(firstName));
    }

    @Test(dependsOnMethods = "createNewOwner")
    public void validateCreatedOwner() {
        AllOwnersPage allOwnersPage = new AllOwnersPage();
        allOwnersPage.clickOnLastCreatedElement();

        OwnerDetailPage ownerDetailPage = new OwnerDetailPage();
        assertEquals(ownerDetailPage.getFullNameText(), firstName + " " + lastName);
        assertEquals(ownerDetailPage.getAddressText(), address);
        assertEquals(ownerDetailPage.getCityText(), city);
        assertEquals(ownerDetailPage.getTelephoneText(), telephone);
    }

    @Test(dependsOnMethods = "validateCreatedOwner")
    public void addNewPetTest() {
        OwnerDetailPage ownerDetailPage = new OwnerDetailPage();
        ownerDetailPage.clickAddNewPet();
        AddPetPage addPetPage = new AddPetPage();
        addPetPage.createNewPet(petName, currentDate, petType);

        assertEquals(ownerDetailPage.getPetNameText(), petName);
        assertEquals(ownerDetailPage.getBirthPetText(), currentDate);
        assertEquals(ownerDetailPage.getPetTypeText(), petType);
    }

    @Test(dependsOnMethods = "addNewPetTest")
    public void addPetVisit() {
        OwnerDetailPage ownerDetailPage = new OwnerDetailPage();
        ownerDetailPage.clickAddVisitButton();

        AddVisitPage addVisitPage = new AddVisitPage();
        addVisitPage.createVisit(currentDate, descriptionText);

        assertEquals(ownerDetailPage.getDescriptionVisitText(), descriptionText);
        assertEquals(ownerDetailPage.getVisitDateText(), currentDate);
    }
}
