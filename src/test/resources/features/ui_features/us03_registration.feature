@register_user
Feature: user_registration
  Scenario: TC_03 user_registration
    Given user goes on "https://www.medunna.com/" home page
    When user click on the account menu icon on page
    When user click on the register link on registration page
    Then User enters a four characters random "<password>"
    Then User enters seven characters "<password>" with a combination by using two of a digit, special char, upper and  lowers letter
    Then User enters seven characters "<password>" with a combination by using three of a digit, special char, upper and  lowers letter
    Then User enters seven characters "<password>" with a combination by using all of a digit, special char, upper and lowers letter
    Then User enters more than seven characters "<password>" with a combination by using all of a digit, special char, upper and lowers letter
    Then user enters a "<password>" that is less than four chars long
    Then user enters a assorted "<password>" that is fifty characters long

