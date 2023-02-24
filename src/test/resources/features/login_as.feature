@login_as
Feature: Login_As
  @login_as_admin
  Scenario: Login_As_Admin
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "AdminTeam03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    Then verify user logged in

  @login_as_patient
  Scenario: Login_As_Patient
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "patient03.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    Then verify user logged in

  @login_as_staff
  Scenario: Login_As_Staff

    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "staff03.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    Then verify user logged in

  @login_as_doctor
  Scenario: Login_As_doctor
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "doctor03.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    Then verify user logged in