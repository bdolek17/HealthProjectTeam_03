@US07 @check_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my profile informations,
  so that I can update my informations.

  @TC001
  Scenario Outline: TC001-There should be user info being populated when navigating to user info "firstname, lastname, email"
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<username>" on login page
    And user enters the password "<password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    Then user verifies firstname lastname and email
    Then close the application
    Examples: test_data
      | username    | password   |
      | AdminTeam03 | Team03+    |
      | patient.t03 | Team03+    |
      | staff.t03   | Team03+    |
      | doctor.t03  | Team03+    |

  @TC002
  Scenario Outline: TC002-There should be an option to update firstname
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<TC002_username>" on login page
    And user enters the password "<TC002_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    And user clears firstname inputbox
    And user enters new "<TC002_firstname>" in firstname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on login page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<TC002_username>" on login page
    And user enters the password "<TC002_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    And verify firstname inputbox has "<TC002_firstname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on login page
    Examples: User Credentials
      | TC002_username    | TC002_password   | TC002_firstname  |
      | patient.t03       | Team03+          | patient-updated  |
      | staff.t03         | Team03+          | staff-updated    |

  @TC003
  Scenario Outline: TC003-There should be an option to update lastname
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<TC003_username>" on login page
    And user enters the password "<TC003_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    And user clears lastname inputbox
    And user enters new "<TC003_lastname>" in lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on login page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<TC003_username>" on login page
    And user enters the password "<TC003_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    And verify lastname inputbox has "<TC003_lastname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on login page
    Examples: User Credentials
      | TC003_username    | TC003_password   | TC003_lastname   |
      | patient.t03       | Team03+          | Hasta-updated    |
      | staff.t03         | Team03+          | Personel-updated |

  @ResetUpdates
  Scenario Outline: TC004-Reset user info to original
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<TC004_username>" on login page
    And user enters the password "<TC004_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    And user clears firstname inputbox
    And user enters new "<TC004_firstname>" in firstname inputbox
    And user clears lastname inputbox
    And user enters new "<TC004_lastname>" in lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on login page
    Examples: User Credentials
      | TC004_username    | TC004_password   | TC004_firstname  | TC004_lastname    |
      | patient.t03       | Team03+          | Patient          | Hasta             |
      | staff.t03         | Team03+          | Staff            | Personel          |