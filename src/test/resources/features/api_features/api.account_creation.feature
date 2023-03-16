Feature: Account Creation
  @accout_create
  Scenario: Account_Create
    Given user sets the request specification
    And user sets the necessary path params
    And user sets the expected data
    When user sends the POST request and gets the response
    Then user validates api records