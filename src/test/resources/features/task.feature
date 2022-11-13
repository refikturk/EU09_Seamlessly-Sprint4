
Feature: User should be on the related module

  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee71"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page

  @wip
  Scenario: User can create a new list of tasks
    Given User clicks on the tasks icon the top of the dashboard page
    When User clicks on the new list module
    And user types a new list of task name "SCHOOL"
    Then user can see new list name of task

  Scenario: User can create a new task name
    When user clicks new task name part
    And user types new task name "Student"
    Then user can see new task name

  Scenario: User can add any task to the list of completed tasks by clicking on the checkbox near the task name
    When user clicks boxOfTaskName
    Then user can see "Completed" task list with the number of tasks

  Scenario: User can add any task to the list of important tasks by clicking on the star icon on the right side of task line
    When user clicks star icon on the right side of task line
    Then user can see important task list with the number of tasks

  Scenario: User can see the number of all uncompleted tasks next to the Current tab
    When user can see Current tab on the right side
    Then user can see the number of all uncompleted tasks next to the Current tab








