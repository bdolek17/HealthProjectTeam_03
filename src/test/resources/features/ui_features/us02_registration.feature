@Registration_US02
  Feature: registration
    @registration_user_email
    Scenario: Registration_user_email
      Given user goes on "https://medunna.com" pagepage
      When user click on the account menu icon on home pagepage
      And user click on the registration link on home page
      And enter "357-85-4323" in SSN input
      And enter "Bulent" in FirstName input
      And enter "Arslan" in LastName input
      And enter "Bulent11" in username input
      And enter "bulent4323@hotmail.com" in Email input
      And enter "Emel2305." in New password input
      And enter "Emel2305." in New password confirmation input
      And click Register button
      Then user should see "Registration Saved" message on the pagepage


@registration_username_negative
Scenario: Registration_username
  Given user goes on "https://medunna.com" on home page
  When user click on the account menu icon on home  page
  And user click on the registration link on home page page
  And enter "587-23-7854" in SSN input on registration page
  And enter "Bulent" in FirstName input on registration page
  And enter "Arslan" in LastName input on registration page
  And enter "bulent2008@gmail.com" in Email input on registration page
  And enter "Emel2305." in New password input on registration page
  And enter "Emel2305." in New password confirmation input on registration page
  And click Register button on registration page
  Then user should see error message on registration page

  @registration_email_negative
  Scenario: Registration_email
    Given user goes on "https://medunna.com" on home pagepage
    When user click on the account menu icon on home  pagepage
    And user click on the registration link on home page pagepage
    And enter "587-23-7412" in SSN input on registration pagepage
    And enter "Bulent" in FirstName input on registration pagepage
    And enter "Arslan" in LastName input on registration pagepage
    And enter "Bulent23" in username input on registration pagepage
    And enter "bulent2008gmail.com" in Email input on registration pagepage
    And enter "Emel2305." in New password input on registration pagepage
    And enter "Emel2305." in New password confirmation input on registration pagepage
    And click Register button on registration pagepage
    Then user should see error message on registration pagepage
