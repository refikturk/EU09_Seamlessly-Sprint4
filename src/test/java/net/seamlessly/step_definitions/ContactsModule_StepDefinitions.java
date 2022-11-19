package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.ContactsModule_Page;
import org.junit.Assert;

public class ContactsModule_StepDefinitions {

    ContactsModule_Page contactsModule_page = new ContactsModule_Page();

    //module name finds the modules on the dashboard
    @When("User clicks on {string} module")
    public void userClicksOnModule(String moduleName) {
        contactsModule_page.navigateToModule(moduleName);
    }

    @Then("User clicks on {string} module from the right side")
    public void userClicksOnModuleFromTheRightSide(String moduleName) {
        contactsModule_page.navigateToRightSideModules(moduleName);
    }

    @Then("User clicks on {string} button from profile menu")
    public void userClicksOnButtonFromProfileMenu(String moduleName) {
        contactsModule_page.settingsMenu(moduleName);
    }

    @And("User clicks on the New contact button")
    public void userClicksOnTheNewContactButton() {
        contactsModule_page.clickNewContactButton();
    }

    @And("User types {string} into the New contact placeholder")
    public void userTypesIntoTheNewContactPlaceholder(String fullName) {
        contactsModule_page.typeContactName(fullName);
    }

    @And("User types {string} and {string}")
    public void userTypesAnd(String companyName, String title) {
        contactsModule_page.putCompanyAndTitle(companyName, title);
    }

    @And("User clicks on the phone type {string} and sends the phone number {string}")
    public void userClicksOnThePhoneTypeAndSendsThePhoneNumber(String phoneType, String phoneNumber) {
        contactsModule_page.inputPhoneNumber(phoneType, phoneNumber);
    }

    @And("User clicks on the email type {string} and sends the emails {string}")
    public void userClicksOnTheEmailTypeAndSendsTheEmails(String emailType, String email) {
        contactsModule_page.inputEmail(emailType, email);
    }

    @And("User clicks on the {string} and sends the {string} information")
    public void userClicksOnTheAndSendsTheInformation(String placeHolderName, String inputInformation) {
        contactsModule_page.addressPlaceHolders(placeHolderName, inputInformation);
    }

    @And("Verify that {string} is seen on the middle column")
    public void verifyThatIsSeenOnTheMiddleColumn(String contactFullName) {
        //contactsModule_page.verifyUserNameIsOnTheMiddleColumn(contactFullName);
        Assert.assertTrue(contactsModule_page.verifyUserNameIsOnTheMiddleColumn().contains(contactFullName));

    }

    @Then("Verify that counts of contacts should be equal to the number next to Not grouped tab")
    public void verifyThatCountsOfContactsShouldBeEqualToTheNumberNextToNotGroupedTab() {
        Assert.assertEquals(contactsModule_page.verifyUserNameIsOnTheMiddleColumn().size(), contactsModule_page.theNumberOfContacts());
    }

    @And("User selects the contact {string} from middle column")
    public void userSelectsTheContactFromMiddleColumn(String contactFullName) {
        contactsModule_page.selectContactFromMiddleSection(contactFullName);
    }

    @And("User clicks on the picture icon")
    public void userClicksOnThePictureIcon() {
        contactsModule_page.clickOnPictureMenuIcon();
    }

    @And("User clicks on {string} buttons")
    public void userClicksOnButton(String buttonName) {
        contactsModule_page.clictToUploadPicture(buttonName);
    }

    @And("User selects a picture {string} to change the profile picture")
    public void userSelectsAPictureToChangeTheProfilePicture(String pictureName) {
        contactsModule_page.selectPictureFromFiles(pictureName);
    }

    @Then("Verify that selected picture is displayed on the contact profile picture")
    public void verifyThatSelectedPictureIsDisplayedOnTheContactProfilePicture() {
    }

    @And("User select Elon musk from middle column")
    public void userSelectElonMuskFromMiddleColumn() {
        contactsModule_page.selectContactFromMiddleSection("Elon Musk");
    }

    @And("User select {string} from middle column")
    public void userSelectFromMiddleColumn(String contactName) {
        contactsModule_page.selectContactFromMiddleSection(contactName);
    }

}
