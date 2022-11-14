@EAMLES-2496
Feature: Deleted Files Tab Functionality under Files Module
  User Story:
  As a user, I should be able to see all deleted files
  and delete/restore them permanently under the Deleted Files tab.

  @SEAMLES-2517
  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee101"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page
    Then User clicks on "FILES" module

  #Background:(precondition to test deleted files) User creates and deletes a file
    When user clicks on the Plus button near the home button
    And user chooses the New text file option
    And user gives the name "File to delete" to the file
    When user clicks the X button at the right corner
    Then user sees "File to delete" is in the list of files
    When user checks the checkbox near the "File to delete"
    And user clicks the Actions dropdown over the list
    And user chooses the Delete option

@SEAMLES-2516
  Scenario: User can see the most recent deleted file in the first line of the deleted files
    When user clicks on the Deleted files tab at the left side of the page
    Then user sees the "File to delete" in the first line of the list

@SEAMLES-2518
  Scenario: User can order all the deleted files based on the date
    When user clicks on the Deleted files tab at the left side of the page
    And user clicks the Deleted button over the files (at the right)
    Then user sees files ordered from the oldest to the newest
    When user clicks the Deleted button over the files (at the right)
    Then user sees files ordered from the newest to the oldest

  @SEAMLES-2519
  Scenario: User can order alphabetically all the deleted files
    When user clicks on the Deleted files tab at the left side of the page
    And user clicks the Name button over the files
    Then user sees files ordered from Z-to-A
    When user clicks the Name button over the files
    Then user sees files ordered from A-to-Z


  @SEAMLES-2521
  Scenario: User can restore any deleted file
    When user clicks on the Deleted files tab at the left side of the page
    And user checks the "File to delete"
    And user clicks the Actions for deleted over the list
    When user chooses the Restore option
    And user clicks the All files tab at the left side
    Then user sees "File to delete" is in the list of files
    #after assertion the created file will be deleted to clean
    And remains cleaned



@SEAMLES-2520
  Scenario: User can delete any deleted file permanently
    When user clicks on the Deleted files tab at the left side of the page
    And user checks the "File to delete"
    And user clicks the Actions for deleted over the list
    When user chooses the Delete permanently
    Then user sees the "File to delete" disappears
















