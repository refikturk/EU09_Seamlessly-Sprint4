package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.NotesPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;

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

        notesPage.noteWritingPage.sendKeys("Hello World!");
        Assert.assertEquals(notesPage.noteWritingPage.getText(), "Hello World!");
    }

    @When("User clicks three dots near the already written note")
    public void user_clicks_three_dots_near_the_already_written_note() {

        BrowserUtils.waitFor(2);
       // BrowserUtils.waitForClickablility(notesPage.threeDots,10);
         BrowserUtils.clickWithJS((notesPage.threeDots));
       // notesPage.threeDots.click();
    }

    @And("User clicks Add to favorites button")
    public void userClicksButton() {
        notesPage.addToFavourites.click();
    }

    @Then("User can add any note to the favorites")
    public void user_can_add_any_note_to_the_favorites() {
        Assert.assertTrue(notesPage.starIcon.isDisplayed());
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
       Assert.assertTrue( notesPage.countOfWordsCharsText.getText().equals("2 words, 12 characters"));
    }

    @And("User write a category name inside the text box and clicks the arrow button")
    public void userWriteACategoryNameInsideTheTextBoxAndClicksTheArrowButton() {
        
    }

    @And("user clicks Category button on the left side of the page under the New Note module")
    public void userClicksCategoryButtonOnTheLeftSideOfThePageUnderTheNewNoteModule() {
        
    }

    @Then("User can create a new category name")
    public void userCanCreateANewCategoryName() {
    }
}
