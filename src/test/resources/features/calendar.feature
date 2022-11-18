@SEAMLES-2492
Feature: US-006 Calendar Module Functionality [Automation-S4]

  Background: User is on the dashboard page after login
    Given user is on the Seamlessly login page
    And user types valid username "Employee41"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page

  @SEAMLES-2509
  Scenario: Verify that user can view Daily calendar module

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And Verify that user sees the Day Button
    And User clicks the Day Button
    Then Verify that user can view Daily Calendar Module Page

  @SEAMLES-2510 #SMOKETEST
  Scenario: Verify that user can view Weekly calendar module

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And Verify that user sees the Weekly Button
    And User clicks the Weekly Button
    Then Verify that user can view Weekly Calendar Module Page

  @SEAMLES-2511
  Scenario: Verify that user can view Monthly calendar module

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And Verify that user sees the Monthly Button
    And User clicks the Monthly Button
    Then Verify that user can view Monthly Calendar Module

  @SEAMLES-2512
  Scenario: Verify that user can create a new event

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And User clicks the Monthly Button
    And User clicks New event Button
    And User types title "voting day" to Event title box
    And User selects event start clock "09.05 am" "June 12 2023"
    And User selects event finish clock "06.00 pm"
    And User adds a location related to the event on "Turkey"
    And User adds a description related to event "hopefully everything will be fine"
    Then User clicks save button to save event

  @SEAMLES-2513
  Scenario: Verify that user sees registered new event on the related day through the Monthly Calendar view

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And User clicks the Monthly Button
    And User clicks to calendar page date button
    And User goes to event date "June 12 2023"
    Then Verify that User sees the new event "voting day" "9:05 am"

  @SEAMLES-2514
  Scenario: User can delete any event through the Monthly Calendar view by clicking on the event and then using “more” option

    When User clicks on "calendar" module
    And Verify that user goes to the calendar module
    And User clicks Time Section Button
    And User clicks the Monthly Button
    And User clicks to calendar page date button
    And User goes to event date "June 12 2023"
    And User clicks the new event "voting day"
    And User clicks more option button
    And User clicks Delete button
    Then Verify that User cannot sees the event "voting day"