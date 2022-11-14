package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.ContactsModule_Page;

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
        contactsModule_page.inputPhoneNumber(phoneType,phoneNumber);
    }

    @And("User clicks on the email type {string} and sends the emails {string}")
    public void userClicksOnTheEmailTypeAndSendsTheEmails(String emailType, String email) {
        contactsModule_page.inputEmail(emailType,email);
    }
}
