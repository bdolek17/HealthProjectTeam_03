@Api_US18
Feature: Api_US18_Feature
  Scenario: :US18_Post_Registration
    Given the user sends POST requests to the "https://medunna.com/api/c-test-items".
    Then Http Status Code should bee 201.
    Then user can create new account successfully.
