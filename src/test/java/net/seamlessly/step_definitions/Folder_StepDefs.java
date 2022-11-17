package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.FolderPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;

public class Folder_StepDefs {

    FolderPage folderPage = new FolderPage();

    @Then("User clicks on {string} button")
    public void user_clicks_on_button(String string) {
        BrowserUtils.waitFor(3);
        folderPage.NameButton.click();
        BrowserUtils.sleep(10);


    }


    @And("User clicks on Size button")
    public void userClicksOnSizeButton() {
        BrowserUtils.waitFor(3);
        folderPage.SizeButton.click();
        BrowserUtils.sleep(10);
    }
    @And("User clicks Modified button")
    public void userClicksModifiedButton() {

        BrowserUtils.waitFor(3);
        folderPage.ModifiedButton.click();
        BrowserUtils.sleep(10);

    }
    @And("User clicks Toggle view button")
    public void userClicksToggleViewButton() {
        BrowserUtils.waitFor(3);
        folderPage.toggleViewButton.click();
        BrowserUtils.sleep(10);

    }
    @Then("User should see the Files and Folders view order has changed")
    public void userShouldSeeTheFilesAndFoldersViewOrderHasChanged() {
        System.out.println("User should see the Files and Folders view order has changed");
        Assert.assertTrue(folderPage.verifyFolderView.getText().contains("amy sheryl"));
        BrowserUtils.waitFor(3);

    }

    @When("User checks the select all checkbox")
    public void user_checks_the_select_all_checkbox() {
        folderPage.clickSelectAllCheckBox();
    }
    @Then("User should see the total count of files and folders")
    public void user_should_see_the_total_count_of_files_and_folders() {
        folderPage.verifyTheTotalCountOfAllItems();
    }


    @Then("User clicks {string} button")
    public void userClicksButton(String arg0) {
    }



}
