Feature: User should be on the related module

  Background: User should be on the dashboard page with valid credentials
    Given user is on the Seamlessly login page
    And user types valid username "Employee31"
    And user types valid password to "Employee123"
    Then user clicks on log in button and lands on the dashboard page


    Scenario: User is on the contacts module
      When User clicks on "CONTACTS" module
      Then  User clicks on "Settings" module from the right side
      Then  User clicks on "Logout" button from profile menu

      Scenario: User should be able to create new contact
        When User clicks on "Contacts" module
        And User clicks on the New contact button
        And User types "contactFullName" into the New contact placeholder
        And User types "contactCompany" into the Company placeholder
        And User types "contactTitle" into the Title placeholder
        And User clicks on the




