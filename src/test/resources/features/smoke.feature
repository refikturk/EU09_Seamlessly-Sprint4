@wiip
Feature: This Smoke Test covers all the crucial Test Cases verifying essential functions on Seamlessly app.

  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee41"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page

  Scenario: User can see the current local time under the Local dropdown
    When user select local time under the local dropdown
    Then user see verify that current local time "Turkish" under the Local dropdown

  Scenario: User can create a new note
    And User click on the pencil icon top of the dashboard page
    When User clicks on the New Note module
    Then User can write notes on the page

  Scenario: Verify that user can view Weekly calendar module

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And Verify that user sees the Weekly Button
    And User clicks the Weekly Button
    Then Verify that user can view Weekly Calendar Module Page