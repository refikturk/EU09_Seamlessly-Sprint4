Feature: User should be on the related module

  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee51"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page


  Scenario: User is on the contacts module
    When User clicks on "CONTACTS" module
    Then  User clicks on "Settings" module from the right side
    Then  User clicks on "Logout" button from profile menu

    @wip
  Scenario: User can select all the files at once and see the
  total values of all files in the first line when clicked
  on the “select all” checkbox at the left top corner of the list
    And User clicks on "Files" module
    When User checks the select all checkbox
    Then User should see the total count of files and folders
