@login_as
Feature: Login_As
  @login_as_admin
  Scenario: Login_As_Admin
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "AdminTeam03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page

  @login_as_patient
  Scenario: Login_As_Patient
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "patient.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page

  @login_as_staff
  Scenario: Login_As_Staff
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "staff.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page

  @login_as_doctor
  Scenario: Login_As_doctor
    Given user is on "https://medunna.com" page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on login page
    And user enters the username "doctor.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page