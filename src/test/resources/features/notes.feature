@SEAMLES-2528
Feature: User should be on the related module

  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee61"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page

  @SEAMLES-2523
  Scenario: User can create a new note
    And User click on the pencil icon top of the dashboard page
    When User clicks on the New Note module
    Then User can write notes on the page

  @SEAMLES-2524
  Scenario: User can add any note to the favorites
    And User click on the pencil icon top of the dashboard page
    When User clicks three dots near the already written note
    And User clicks Add to favorites button
    Then User can add any note to the favorites

  @SEAMLES-2525
  Scenario: User can see the number of letters and words that the
  note includes under the note title when clicked on the details of the note
    When User click on the pencil icon top of the dashboard page
    And User clicks the three dots near the image icon
    And User clicks Details button
    Then User can see the number of letters and words

  @SEAMLES-2526
  Scenario: User can create a new category by passing a new category name from inside the notes details
    When User click on the pencil icon top of the dashboard page
    And User clicks the three dots near the image icon
    And User clicks Details button
    And User write a category name inside the text box
    And User clicks the arrow button
    And user clicks Category button on the left side of the page under the New Note module
    Then User can create a new category name

  @SEAMLES-2527
  Scenario: User can delete any note
    When User click on the pencil icon top of the dashboard page
    And User clicks three dots near the to be deleted note
    And User clicks Delete note button
    Then User can delete any note
