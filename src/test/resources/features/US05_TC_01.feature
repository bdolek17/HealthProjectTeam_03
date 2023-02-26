@Login_page
Feature: US05_TC_01
@patient_login_
  Scenario: Login_As_Patient
    Given patientt is on "https://medunna.com/" page
    When patientt clicks on the account menu icon on home page
    And patientt clicks on the sign in link on login page
    And patientt enters the username "patient.t03" on login page