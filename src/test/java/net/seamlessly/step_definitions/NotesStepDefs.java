package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.NotesPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class NotesStepDefs {

    NotesPage notesPage = new NotesPage();

    @Given("User click on the pencil icon top of the dashboard page")
    public void user_click_on_the_pencil_icon_top_of_the_dashboard_page() {
        notesPage.pencilIcon.click();
    }

    @When("User clicks on the New Note module")
    public void user_clicks_on_the_new_note_module() {
        notesPage.newNoteModule.click();
    }

    @Then("User can write notes on the page")
    public void user_can_write_notes_on_the_page() {
        BrowserUtils.waitFor(2);
        notesPage.noteWritingPage.sendKeys("Hello World!");
        Assert.assertEquals(notesPage.noteWritingPage.getText(), "Hello World!");
    }

    @When("User clicks three dots near the already written note")
    public void user_clicks_three_dots_near_the_already_written_note() {

        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(notesPage.clickThreeDotByText("Arife"));
    }

    @And("User clicks Add to favorites button")
    public void userClicksButton() {
        notesPage.addToFavourites.click();
    }

    @Then("User can add any note to the favorites")
    public void user_can_add_any_note_to_the_favorites() {
        if (Driver.getDriver().findElements(By.xpath("//div[@class='app-navigation-entry-icon nav-icon icon-starred']"))
                .size() > 0) {
            notesPage.starIcon.isDisplayed();
        }

    }


   /* @When("User clicks on the any notes")
    public void userClicksOnTheAnyNotes() {
        notesPage.note.click();
    }

    */


    @And("User clicks the three dots near the image icon")
    public void userClicksTheThreeDotsNearTheImageIcon() {
        notesPage.detailsThreeDots.click();
    }

    @And("User clicks Details button")
    public void userClicksDetailsButton() {
        notesPage.detailsButton.click();
    }


    @Then("User can see the number of letters and words")
    public void userCanSeeTheNumberOfLettersAndWords() {
        notesPage.verifyTheTotalCountOfAllItems();
    }

    @And("User write a category name inside the text box")
    public void userWriteACategoryNameInsideTheTextBox() {
        notesPage.category.sendKeys("animals");

    }

    @And("User clicks the arrow button")
    public void userClicksTheArrowButton() {
        notesPage.arrowIcon.click();
    }

    @And("user clicks Category button on the left side of the page under the New Note module")
    public void userClicksCategoryButtonOnTheLeftSideOfThePageUnderTheNewNoteModule() {
        BrowserUtils.clickWithJS(notesPage.categoriesModule);
    }

    @Then("User can create a new category name")
    public void userCanCreateANewCategoryName() {
        if (Driver.getDriver().findElements(By.xpath("//span[@title='animals']"))
                .size() > 0) {
            notesPage.animalCategory.isDisplayed();
        }
    }


    @And("User clicks three dots near the to be deleted note")
    public void userClicksThreeDotsNearTheToBeDeletedNote() {
        BrowserUtils.clickWithJS(notesPage.deleteNoteThreeDots);
    }

    @And("User clicks Delete note button")
    public void userClicksDeleteNoteButton() {
        notesPage.deleteModule.click();
    }

    @Then("User can delete any note")
    public void userCanDeleteAnyNote() {
        if(Driver.getDriver().findElements(By.xpath("//span[@title='Hello World']")).size() == 0){
         Assert.assertFalse(notesPage.helloWorldText.isDisplayed());
        }
    }
}
