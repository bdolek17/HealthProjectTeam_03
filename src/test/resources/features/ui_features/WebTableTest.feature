@US16_PatientCreationAutherization
Feature: TestWebTableReader

  @web_table
  Scenario: Web Table Tester
    Given user is on medunna home page
    When user logs in as admin with the username as "AdminTeam03" and password as "Team03+" to web app
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    Then user reads web table