@US07_Editable_Fields @edit_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_TC002
  Scenario Outline: TC002-There should be an option to update firstname
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC002_username>" on login page
    And user enters the password "<TC002_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<TC002_firstname>" firstname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC002_username>" on login page
    And user enters the password "<TC002_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And verify firstname inputbox has "<TC002_firstname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC002_username    | TC002_password   | TC002_firstname  |
      | patient03.t03       | Team03+          | Patient-03-updated  |
      | staff03.t03         | Team03+          | Staff-03-updated    |

  @US07_TC003  #negative of TC002
  Scenario Outline: TC003-Firstname can not be updated with missing value
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC003_username>" on login page
    And user enters the password "<TC003_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "" firstname inputbox
    And user clicks save button
    And verify firstname is required message text visibility

    Examples: User Credentials
      | TC003_username    | TC003_password  |
      | patient03.t03       | Team03+         |
      #| staff03.t03         | Team03+        |


  @US07_TC004
  Scenario Outline: TC004-There should be an option to update lastname
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC004_username>" on login page
    And user enters the password "<TC004_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<TC004_lastname>" lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC004_username>" on login page
    And user enters the password "<TC004_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And verify lastname inputbox has "<TC004_lastname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC004_username    | TC004_password   | TC004_lastname   |
      | patient03.t03       | Team03+          | Hasta-updated    |
      | staff03.t03         | Team03+          | Personel-updated |


  @US07_TC005  #negative of TC004
  Scenario Outline: TC005-LastName can not be updated with missing value
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC005_username>" on login page
    And user enters the password "<TC005_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "" lastname inputbox
    And user clicks save button
    And verify lastname is required message text visibility
    Examples: User Credentials
      | TC005_username    | TC005_password   |
      | patient03.t03       | Team03+          |
      #| staff03.t03         | Team03+          |



  @US07_ResetUpdates
  Scenario Outline: TC006-Reset user info to original
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC004_username>" on login page
    And user enters the password "<TC004_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<TC004_firstname>" firstname inputbox
    And user enters new "<TC004_lastname>" lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC004_username  | TC004_password   | TC004_firstname  | TC004_lastname    |
      | patient03.t03   | Team03+          | Patient-03          | Hasta             |
      | staff03.t03     | Team03+          | Staff-03            | Personel          |
      | doctor03.t03    | Team03+          | Staff-03            | Personel          |