@US16_PatientCreationAutherization
Feature: (Create or Edit Patient by just Admin, Validate with API)
  As an <admin>,
  I want to view my patient create and edit page,
  so that Only I can create patient.

  @US16_TC01
  Scenario: US16_TC01 [Create or edit a Patient] should only be viewable by the admin
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "AdminTeam03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    And user click on ItemsAndTitles menu
    And user verifies admin patient menu is visible
    And user click on admin patient menu
    Then user verifies that all patients page is opened
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page

  @US16_TC02
  Scenario Outline: US16_TC02 [Create or edit a Patient] should not be viewable by the staf or doctor user
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<username>" on login page
    And user enters the password "<password>" on login page
    And user clicks on sign in button on login page
    And user verifies admin items and titles menu is not visible
    And user goes on "https://medunna.com/patient" page
    Then user verifies that "You are not authorized to access this page." message on the page
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: test_data
      | username      | password   |
      | staff03.t03   | Team03+    |
      | doctor03.t03  | Team03+    |
      #| patient03.t03 | Team03+    |
