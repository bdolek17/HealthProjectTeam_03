@US07 @check_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_TC001
  Scenario Outline: TC001-There should be user info being populated when navigating to user info "firstname, lastname, email"
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "<username>" on login page
    And user enters the password "<password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on login page
    Then user verifies the setting page
    Then close the application
    Examples: test_data
      | username    | password   |
      | AdminTeam03 | Team03+    |
      | patient.t03 | Team03+    |
      #| staff.t03   | Team03+    |
      #| doctor.t03  | Team03+    |
