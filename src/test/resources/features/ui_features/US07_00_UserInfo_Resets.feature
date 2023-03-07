@US07_
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_ResetUserInfoUpdates
  Scenario Outline: Reset user info to original
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<reset_username>" on login page
    And user enters the password "<reset_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<reset_firstname>" firstname inputbox
    And user enters new "<reset_lastname>" lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | reset_username  | reset_password   | reset_firstname  | reset_lastname    |
      | patient03.t03   | Team03+          | Patient-03       | Hasta             |
      | staff03.t03     | Team03+          | Staff-03         | Personel          |
      | doctor03.t03    | Team03+          | Doctor-03        | Personel          |