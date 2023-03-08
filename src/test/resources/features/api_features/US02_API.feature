
@US02_API
Feature: US02_API

  Scenario Outline: registrant_test
    Given user sets the necessary path params params "https://medunna.com/api/register"
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" and  "<password>"
    And user sends the POST request and gets the response body
    When user saves the api records to correspondent files
    Then user validates api records data

    Examples: api test data
      |firstname|lastname|SSN|email|username|password|
      |Emel   |Arslan |293-38-2305|emel@gmail.com|emelarslan|emel2305.|



