Feature: Staff Creation
  @staff_create
  Scenario: Staff_Create
    Given user sets the request specification
    And user sets the expected data for staff
    When user sends the POST request for staff and gets the response
    Then user validates api records