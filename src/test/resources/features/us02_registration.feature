@registration_user_email
  Feature: registration
    Scenario: Registration_user_email
      Given user goes on "https://medunna.com" pagepage
      When user click on the account menu icon on home page
      And user click on the registration link on home page
      And enter "123-52-5687" in SSN input
      And enter "Emel" in FirstName input
      And enter "Arslan" in LastName input
      And enter "Emel01" in username input
      And enter "emel@gmail.com" in Email input
      And enter "Emel2305." in New password input
      And enter "Emel2305." in New password confirmation input
      And click Register button


@registration_email
Scenario: Registration_email
  Given user goes on "https://medunna.com" page
  When user click on the account menu icon on home page
  And user click on the registration link on home page