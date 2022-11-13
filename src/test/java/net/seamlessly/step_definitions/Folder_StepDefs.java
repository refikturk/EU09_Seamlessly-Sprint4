package net.seamlessly.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.FolderPage;
import net.seamlessly.utilities.BrowserUtils;

public class Folder_StepDefs {

    FolderPage folderPage = new FolderPage();

    @When("User checks the select all checkbox")
    public void user_checks_the_select_all_checkbox() {
        folderPage.clickSelectAllCheckBox();
    }
    @Then("User should see the total count of files and folders")
    public void user_should_see_the_total_count_of_files_and_folders() {
        folderPage.verifyTheTotalCountOfAllItems();
    }
}
