@US07_Editable_Fields @edit_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_TC002
  @FirstNameUpdateTest
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
    And user enters new "<TC002_updatedFirstname>" firstname inputbox
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
    And verify firstname inputbox has "<TC002_updatedFirstname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC002_username    | TC002_password   | TC002_updatedFirstname  |
      | patient03.t03     | Team03+          | Patient-03-updated      |
      #| staff03.t03         | Team03+          | Staff-03-updated    |


  @US07_TC005  #negative of TC002
  Scenario Outline: TC005-Firstname can not be updated with missing value
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC005_username>" on login page
    And user enters the password "<TC005_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "" firstname inputbox
    And user clicks save button
    And verify firstname is required message text visibility

    Examples: User Credentials
      | TC005_username    | TC005_password  |
      | patient03.t03     | Team03+         |
      #| staff03.t03         | Team03+        |


  @US07_TC006
  Scenario Outline: TC006-There should be an option to update lastname
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC006_username>" on login page
    And user enters the password "<TC006_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<TC006_updatedLastname>" lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC006_username>" on login page
    And user enters the password "<TC006_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And verify lastname inputbox has "<TC006_updatedLastname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC006_username    | TC006_password   | TC006_updatedLastname   |
      | patient03.t03       | Team03+          | Hasta-updated    |
      #| staff03.t03         | Team03+          | Personel-updated |

  @US07_TC009  #negative of TC006
  Scenario Outline: TC005-LastName can not be updated with missing value
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC009_username>" on login page
    And user enters the password "<TC009_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "" lastname inputbox
    And user clicks save button
    And verify lastname is required message text visibility
    Examples: User Credentials
      | TC009_username    | TC009_password   |
      | patient03.t03     | Team03+          |
      #| staff03.t03         | Team03+          |



