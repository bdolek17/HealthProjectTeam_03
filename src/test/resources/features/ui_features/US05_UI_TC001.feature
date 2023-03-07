@Login_page
Feature: US05_TC_01
@patient_login_
  Scenario: Login_As_Patient
    Given patientt is on "https://medunna.com/" page
    When patientt clicks on the account menu icon on home page
    And patientt clicks on the sign in link on login page
    And patientt enters the username "patient.t03" on login page
  And patientt enters the password "Team03+" on login page
  And patientt clicks on the remember me box
  And patientt clicks on sign in button on login page
  And patientt clicks on patient menu icon on login page
  And patientt clicks on Sign out link on login page
  And patientt click on the account menu icon on home page
  And patientt click on the sign in link on login page
  Then patientt should see username and password come automatically to log in to the system again
  And patientt clicks the cancel button.
  When patienttt clicks on the account menu icon on home page
  And patientt clicks sign in button on home page
  And patientt navigate to link of Register a new account


