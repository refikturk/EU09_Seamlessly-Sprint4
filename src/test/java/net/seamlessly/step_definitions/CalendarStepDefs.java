package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.CalendarPage;

public class CalendarStepDefs {

    CalendarPage calendarPage = new CalendarPage();

    @Then("Verify that user goes to the calendar module")
    public void verify_that_user_goes_to_the_calendar_module() {
        calendarPage.verifyViewCalendarPage();
    }

    @Then("User clicks Time Section Button")
    public void user_clicks_time_section_button() {
        calendarPage.clickTimeSectionsBtn();
    }

    @Then("Verify that user sees the Day Button")
    public void verify_that_user_sees_the_day_button() {
        calendarPage.verifyViewDayBtn();
    }

    @Then("User clicks the Day Button")
    public void user_clicks_the_day_button() {
        calendarPage.clickDayBtn();
    }

    @Then("Verify that user can view Daily Calendar Module Page")
    public void verify_that_user_can_view_daily_calendar_module_page() {
        calendarPage.verifyDailyCalendarModuleIsDisplayed();
    }

    @Then("Verify that user sees the Weekly Button")
    public void verify_that_user_sees_the_weekly_button() {

        calendarPage.verifyViewWeekBtn();
    }

    @Then("User clicks the Weekly Button")
    public void user_clicks_the_weekly_button() {

        calendarPage.clickWeekBtn();
    }

    @Then("Verify that user can view Weekly Calendar Module Page")
    public void verify_that_user_can_view_weekly_calendar_module_page() {
        calendarPage.verifyWeeklyCalendarModuleIsDisplayed();
    }

    @Then("Verify that user sees the Monthly Button")
    public void verify_that_user_sees_the_monthly_button() {
        calendarPage.verifyViewMonthBtn();
    }
    @Then("User clicks the Monthly Button")
    public void user_clicks_the_monthly_button() {
        calendarPage.clickMonthBtn();
    }

    @Then("Verify that user can view Monthly Calendar Module")
    public void verifyThatUserCanViewMonthlyCalendarModule() {
        calendarPage.verifyMonthlyCalendarModuleIsDisplayed();
    }

    @Then("User clicks New event Button")
    public void user_clicks_new_event_button() {
        calendarPage.clickNewEventBtn();
    }
    @Then("User types title {string} to Event title box")
    public void user_types_title_to_event_title_box(String eventTitle) {
        calendarPage.typeNewEventTitle(eventTitle);
    }
    @And("User selects event start clock {string} {string}")
    public void userSelectsEventStartClock(String startTime, String eventDate) {
        calendarPage.selectedEventStartDate(startTime,eventDate);
    }
    @And("User selects event finish clock {string}")
    public void userSelectsEventFinishClock(String finishedTime) {
        calendarPage.selectedEventFinishedDate(finishedTime);
    }
    @And("User adds a location related to the event on {string}")
    public void userAddsALocationRelatedToTheEventOn(String eventLocation) {
        calendarPage.typeEventLocation(eventLocation);
    }
    @And("User adds a description related to event {string}")
    public void userAddsADescriptionRelatedToEvent(String eventDescription) {
        calendarPage.typeEventDescription(eventDescription);
    }
    @Then("User clicks save button to save event")
    public void user_clicks_save_button_to_save_event() {
        calendarPage.clickEventSaveBtn();
    }

    @When("User clicks to calendar page date button")
    public void user_clicks_to_calendar_page_date_button() {
        calendarPage.clickCalendarDateBtn();
    }

    @When("User goes to event date {string}")
    public void user_goes_to_event_date(String date) {
        calendarPage.entryEventDate(date);
    }

    @Then("Verify that User sees the new event {string} {string}")
    public void verifyThatUserSeesTheNewEvent(String eventTitle, String eventHour) {
        calendarPage.verifyViewEvent(eventTitle,eventHour);
    }


    @And("User clicks the new event {string}")
    public void userClicksTheNewEvent(String eventTitle) {
        calendarPage.clickEventTitle(eventTitle);
    }

    @And("User clicks more option button")
    public void userClicksMoreOptionButton() {
        calendarPage.clicksMoreOptionsBtn();
    }


    @And("User clicks Delete button")
    public void userClicksDeleteButton() {
        calendarPage.clickDeleteBtn();
    }

    @Then("Verify that User cannot sees the event {string}")
    public void verifyThatUserCannotSeesTheEvent(String eventTitle) {
        calendarPage.verifyEventIsNotDisplayed(eventTitle);
    }
}

