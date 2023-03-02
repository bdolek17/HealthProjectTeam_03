@registration
Feature: Registration

  Scenario: Registration_As_Patient
    Given the user is on "https://medunna.com" registration pages
    When user clicks on the account menu icons
    And user clicks on the sign in link on registration pages
    And user enters the valid "SSN" on registration pages
    And user enters the firstname on registration pages
    And user enters the lastname on registration pages
    And user enters the username on registration pages
    And user enters the email on registration pages
    And user enters the password on registration pages
    And user enters the confirmation password on registration pages
    And user clicks on register buttons
    Then user should see "Registration Saved" message on the pages

    @registration_invalid_SSN
    Scenario: Registration_invalid_SSN
      Given the user is on "https://medunna.com" registration pages
      When user clicks on the account menu icons
      And user clicks on the sign in link on registration pages
      And user enters the missing "SSN" on registration pages
      And user should be see error message
      And user enters the without line "SSN"
      And user should be see error2 message