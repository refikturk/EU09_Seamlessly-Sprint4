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

  @wipContacts
  Scenario Outline: User should be able to create new contact
    When User clicks on "Contacts" module
    And User clicks on the New contact button
    And User types "<contactFullName>" into the New contact placeholder
    And User types "<Company>" and "<Title>"
    And User clicks on the phone type "<phoneType>" and sends the phone number "<phoneNumber>"
    And User clicks on the email type "<emailType>" and sends the emails "<email>"
    And User clicks on the PO Box "Post office box" and sends the "<POBox>" information
    And User clicks on the PO Box "Address" and sends the "<POBox>" information
    And User clicks on the PO Box "Extended Address" and sends the "<POBox>" information
    And User clicks on the PO Box "Postal code" and sends the "<POBox>" information
    And User clicks on the PO Box "City" and sends the "<POBox>" information
    And User clicks on the PO Box "State or province" and sends the "<POBox>" information
    And User clicks on the PO Box "Country" and sends the "<POBox>" information


    Examples: Contacts information
      | contactFullName | Company   | Title   | phoneType | phoneNumber | emailType | email               | POBox | Address | Extended address | Postal Code | City | State or province | Country |
      | Bill Gates      | Microsoft | Founder | Work      | 18776788033 | Work      | billgates@gmail.com |       |         |                  |             |      |                   |         |




