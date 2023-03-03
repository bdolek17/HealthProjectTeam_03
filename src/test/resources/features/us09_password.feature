@user_password
Feature: user_password
  Scenario: TC_09 user_password
    Given user goes "https://www.medunna.com/" home page
    When user click on the account menu icon page
    When user click on the sign link
    Then User enters username
    Then User enters password
    Then User click sign in button
    Then User click password button


