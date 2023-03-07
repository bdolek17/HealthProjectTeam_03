@Api_US01
Feature: Api_US01_Feature
  Scenario: :TC02_Post_Registration
    Given the user sends POST requests to the "https://medunna.com/api/register"
    Then Http Status Code should bee 200
    Then user can create new account successfully
