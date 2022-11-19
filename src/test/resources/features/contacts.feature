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
    And User clicks on the "Post office box" and sends the "<POBox>" information
    And User clicks on the "Address" and sends the "<Address>" information
    And User clicks on the "Extended address" and sends the "<Extended address>" information
    And User clicks on the "Postal code" and sends the "<Postal code>" information
    And User clicks on the "City" and sends the "<City>" information
    And User clicks on the "State or province" and sends the "<State or province>" information
    And User clicks on the "Country" and sends the "<Country>" information
    And User clicks on the phone type "<phoneType>" and sends the phone number "<phoneNumber>"
    And User clicks on the email type "<emailType>" and sends the emails "<email>"
    Then Verify that "<contactFullName>" is seen on the middle column
    And User clicks on log out button



    Examples: Contacts information
      | contactFullName | Company   | Title   | phoneType | phoneNumber | emailType | email               | POBox | Address | Extended address | Postal code | City    | State or province | Country |
      | Bill Gates      | Microsoft | Founder | Work      | 4441122     | Work      | billgates@gmail.com | 36360 | Redmond | Washington       | 36360       | Redmond | Washington        | USA     |
      | Elon Musk       | Tesla     | CEO     | Home      | 3550555     | Other     | elonmusk@tesla.com  | 38400 | Florida | Florida          | 36360       | Florida | Florida           | USA     |
      | Nuray Mercan    | CheckOS   | Founder | Work      | 312555411   | Work      | nmercan@checkos.com | 36360 | Cankaya | Ankara, Turkey   | 36360       | Ankara  | Cankaya           | Turkey  |

  @wipContacts2
  Scenario: User should see all the contacs as a list inside the middle column
  and the total number of contacts near the "All Contacts" tab
    When User clicks on "Contacts" module
    Then  Verify that counts of contacts should be equal to the number next to Not grouped tab

  Scenario: User should be able to change the profile picture of any contact with a
  previously uploaded picture by using “Choose from files” option
    When User clicks on "Contacts" module
    And User selects the contact "<contactFullName>" from middle column
    And User clicks on the picture icon
    And User clicks on "Choose from Files" buttons
    And User selects a picture "<fileName>" to change the profile picture
    Then  Verify that selected picture is displayed on the contact profile picture
      | contactFullName | fileName    |
      | Bill Gates      | Bill_Gates1 |
      | Elon Musk       | elon_musk   |







