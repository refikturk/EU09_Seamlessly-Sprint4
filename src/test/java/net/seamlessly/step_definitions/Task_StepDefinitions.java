package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.pages.TaskPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;

public class Task_StepDefinitions  {

    TaskPage taskPage=new TaskPage();



    @Given("User clicks on the tasks icon the top of the dashboard page")
    public void user_clicks_on_the_tasks_icon_the_top_of_the_dashboard_page() {
        taskPage.tasksModule.click();
    }
    @When("User clicks on the add list module")
    public void user_clicks_on_the_add_list_module() {
        taskPage.addListName.click();

    }
    @When("user types a new list  name {string}")
    public void user_types_a_new_list_name(String string) {
        taskPage.typeNewListBox(string);
    }
    @Then("user can see the new list name")
    public void user_can_see_the_new_list_name() {
    BrowserUtils.sleep(10);
    taskPage.newListName.isDisplayed();
    }




    @When("user clicks new task name part")
    public void user_clicks_new_task_name_part() {
        taskPage.addAtask.click();

    }
    @When("user types new task name {string}")
    public void user_types_new_task_name(String string) {
        taskPage.addAtask.sendKeys("Student");
        BrowserUtils.waitFor(10);
        Assert.assertEquals(taskPage.addAtask.getText(),"Student");
    }
    @Then("user can see new task name")
    public void user_can_see_new_task_name() {
        BrowserUtils.sleep(10);
        taskPage.newTaskName.isDisplayed();
    }

    @When("user clicks boxOfTaskName")
    public void user_clicks_box_of_task_name() {

    }
    @Then("user can see {string} task list with the number of tasks")
    public void user_can_see_task_list_with_the_number_of_tasks(String string) {

    }


    @When("user clicks star icon on the right side of task line")
    public void user_clicks_star_icon_on_the_right_side_of_task_line() {

    }
    @Then("user can see important task list with the number of tasks")
    public void user_can_see_important_task_list_with_the_number_of_tasks() {

    }

    @When("user can see Current tab on the right side")
    public void user_can_see_current_tab_on_the_right_side() {

    }
    @Then("user can see the number of all uncompleted tasks next to the Current tab")
    public void user_can_see_the_number_of_all_uncompleted_tasks_next_to_the_current_tab() {

    }


}
