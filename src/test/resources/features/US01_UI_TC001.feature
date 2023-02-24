@registration
  Feature: Registration

    Scenario: Registration_As_Patient
      Given user is on "https://medunna.com/" registration page
      When user clicks on the account menu icon on home page
      And user clicks on the sign in link on registration page
      And user enters the valid "SSN" on registration page
      And user enters the firstname on registration page
      And user enters the lastname on registration page
      And user enters the username on registration page
      And user enters the email on registration page
      And user enters the password on registration page
      And user enters the confirmation password on registration page
      And user clicks on register button
      Then user should see "Registration Saved" message on the page

     ## @registration_negative_scenario
     ## Scenario: Negative_scenario
      #  Given user is on "https://medunna.com" page


    


