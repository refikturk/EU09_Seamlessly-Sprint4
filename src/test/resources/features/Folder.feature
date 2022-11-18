@SEAMLES-2537
Feature: User should be on the related module

  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee51"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page

   @SEAMLES-2531
  Scenario: User is on the contacts module
    When User clicks on "CONTACTS" module
    And  User clicks on "Settings" module from the right side
    Then  User clicks on "Logout" button from profile menu

  @SEAMLES-2532
  Scenario: User can change folder view order by Name
    When User clicks on "Files" module
    And User clicks on "Name" button
    Then User should see the Files and Folders view order has changed
  @SEAMLES-2533
  Scenario:User can change folder view order by Size
      When User clicks on "Files" module
      And User clicks on Size button
      Then User should see the Files and Folders view order has changed
  @SEAMLES-2534
  Scenario: User can change folder view order by Modified
    When User clicks on "Files" module
    And User clicks Modified button
    Then User should see the Files and Folders view order has changed

  @SEAMLES-2535
  Scenario: User can change the folder view by clicking the toggle-view button at the right corner of all files tab screen
    When User clicks on "Files" module
    And User clicks Toggle view button
    Then User should see the Files and Folders view order has changed
    Then User clicks Toggle view button again

  @SEAMLES-2536
  Scenario: User can select all the files at once and see the
  total values of all files in the first line when clicked
  on the “select all” checkbox at the left top corner of the list
    And User clicks on "Files" module
    When User checks the select all checkbox
    Then User should see the total count of files and folders
