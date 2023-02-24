@ApiRegistrationTest
Feature: Registration Test
  Scenario: Registration Test
    Given user sets the necessary path params
    And user sets the expected data
    When  user sends the POST request and gets the response
    Then user validates api records