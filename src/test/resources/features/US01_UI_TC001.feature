@registration
  Feature: Registration
    @registration_positive_scenario
    Scenario: Registration_As_Patient
      Given user is on "https://medunna.com" page
      When user clicks on the account menu icon on home page
      And user clicks on the sign in link on registration page
      And user enters the valid "SSN" on login page
      And user enters the "firstname" on login page
      And user enters the "lastname" on login page
      And user enters the "username" on login page
      And user enters the "email" on login page
      And user enters the "password" on login page
      And user enters the "confirmation password" on login page
      And user clicks on register button
      Then user should see "saved" message on the page
