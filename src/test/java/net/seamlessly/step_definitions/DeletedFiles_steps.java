package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import net.seamlessly.pages.DeletedFilesPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class DeletedFiles_steps {
    DeletedFilesPage deletedFilesPage = new DeletedFilesPage();

    @When("user clicks on the Plus button near the home button")
    public void userClicksOnThePlusButtonNearTheHomeButton() {
        deletedFilesPage.plusButton.click();
    }

    @And("user chooses the New text file option")
    public void userChoosesTheNewTextFileOption() {
        deletedFilesPage.newTextFile.click();
    }

    @And("user gives the name {string} to the file")
    public void userGivesTheNameToTheFile(String arg0) {
        deletedFilesPage.giveName.sendKeys(arg0 + Keys.ENTER);
    }

    @When("user clicks the X button at the right corner")
    public void userClicksTheXButtonAtTheRightCorner() {
        BrowserUtils.sleep(3);
        deletedFilesPage.xButton.click();
    }

    @Then("user sees {string} is in the list of files")
    public void userSeesIsInTheListOfFiles(String arg0) {
        for (WebElement each : deletedFilesPage.allFiles) {
            if (!each.getAttribute("data-file").contains(arg0)) {
                continue;
            } else {
                Assert.assertTrue(true);
            }
        }
    }

    @When("user checks the checkbox near the {string}")
    public void userChecksTheCheckboxNearThe(String arg0) {
        for (WebElement each : deletedFilesPage.allFiles) {
            if (each.getAttribute("data-file").contains(arg0)) {
                int index = deletedFilesPage.allFiles.indexOf(each) + 1;
                Driver.getDriver().findElement(By.xpath("((//tbody[@id='fileList'])[1]//tr)[" + index + "]/td")).click();

            }

        }
    }

    @And("user clicks the Actions dropdown over the list")
    public void userClicksTheActionsDropdownOverTheList() {
        deletedFilesPage.actions.click();
    }

    @And("user chooses the Delete option")
    public void userChoosesTheDeleteOption() {
        deletedFilesPage.actionsDelete.click();
    }

    @When("user clicks on the Deleted files tab at the left side of the page")
    public void userClicksOnTheDeletedFilesTabAtTheLeftSideOfThePage() {
        deletedFilesPage.deletedFilesTab.click();
    }

    @Then("user sees the {string} in the first line of the list")
    public void userSeesTheInTheFirstLineOfTheList(String arg0) {
        Assert.assertTrue(deletedFilesPage.firstDeleted.getAttribute("data-file").contains(arg0));
        DeletedFilesPage.deletePermanently();
    }

    @And("user clicks the Deleted button over the files \\(at the right)")
    public void userClicksTheDeletedButtonOverTheFilesAtTheRight() {
        BrowserUtils.sleep(3);
        deletedFilesPage.deletedButton.click();
    }

    @Then("user sees files ordered from the oldest to the newest")
    public void userSeesFilesOrderedFromTheOldestToTheNewest() {
        ArrayList<Long> deletedDates = new ArrayList<>();
        for (WebElement each : deletedFilesPage.deletedFiles) {
            deletedDates.add(Long.valueOf(each.getAttribute("data-etag")));
        }
        ArrayList<Long> copy = new ArrayList<>(deletedDates);
        copy.sort(Comparator.naturalOrder());

        Assert.assertTrue(deletedDates.equals(copy));

    }

    @Then("user sees files ordered from the newest to the oldest")
    public void userSeesFilesOrderedFromTheNewestToTheOldest() {
        ArrayList<Long> deletedDates = new ArrayList<>();
        for (WebElement each : deletedFilesPage.deletedFiles) {
            deletedDates.add(Long.valueOf(each.getAttribute("data-etag")));
        }
        ArrayList<Long> copy = new ArrayList<>(deletedDates);
        copy.sort(Comparator.naturalOrder());
        copy.sort(Comparator.reverseOrder());
        Assert.assertTrue(deletedDates.equals(copy));

        DeletedFilesPage.deletePermanently();
    }

    @And("user clicks the Name button over the files")
    public void userClicksTheNameButtonOverTheFiles() {
        deletedFilesPage.nameButton.click();

    }

    @Then("user sees files ordered from Z-to-A")
    public void userSeesFilesOrderedFromZToA() {
        DeletedFilesPage.deletePermanently();
        ArrayList<String> namesList = new ArrayList<>();

        for (WebElement each : deletedFilesPage.deletedFilesNames) {
            namesList.add(each.getText());
        }

        ArrayList<String> copy = new ArrayList<>(namesList);

        copy.sort(Comparator.naturalOrder());
        copy.sort(Comparator.reverseOrder());

        Assert.assertTrue(namesList.equals(copy));

    }

    @Then("user sees files ordered from A-to-Z")
    public void userSeesFilesOrderedFromAToZ() {

        ArrayList<String> namesList = new ArrayList<>();

        for (WebElement each : deletedFilesPage.deletedFilesNames) {
            namesList.add(each.getText());
        }

        ArrayList<String> copy = new ArrayList<>(namesList);
        copy.sort(Comparator.naturalOrder());
        BrowserUtils.sleep(3);
        Assert.assertTrue(namesList.equals(copy));

        DeletedFilesPage.deletePermanently();


    }


    @And("user clicks the All files tab at the left side")
    public void userClicksTheAllFilesTabAtTheLeftSide() {
        deletedFilesPage.allFilesTab.click();

    }

    @And("user checks the {string}")
    public void userChecksThe(String arg0) {
        deletedFilesPage.checkboxDeleted.click();
    }

    @And("user clicks the Actions for deleted over the list")
    public void userClicksTheActionsForDeletedOverTheList() {
        deletedFilesPage.deletedActions.click();
    }

    @When("user chooses the Restore option")
    public void userChoosesTheRestoreOption() {
        deletedFilesPage.restoreIcon.click();
    }


    @When("user chooses the Delete permanently")
    public void userChoosesTheDeletePermanently() {
        deletedFilesPage.deleteIcon.click();
    }

    @Then("user sees the {string} disappears")
    public void userSeesTheDisappears(String arg0) {
        BrowserUtils.sleep(3);
        boolean isDeleted = true;
        for (WebElement each : deletedFilesPage.deletedFiles) {
            if (each.getAttribute("data-path").contains(arg0)) {
                isDeleted = false;
            }
        }
        Assert.assertTrue(isDeleted);

    }


    @And("remains cleaned")
    public void remainsCleaned() {
        BrowserUtils.sleep(3);
        for (WebElement each : deletedFilesPage.allFiles) {
            if (each.getAttribute("data-file").contains("File to delete")) {
                int index = deletedFilesPage.allFiles.indexOf(each) + 1;
                Driver.getDriver().findElement(By.xpath("((//tbody[@id='fileList'])[1]//tr)[" + index + "]/td")).click();

            }
        }
        deletedFilesPage.actions.click();
        deletedFilesPage.actionsDelete.click();
        deletedFilesPage.deletedFilesTab.click();
        DeletedFilesPage.deletePermanently();


    }
}
