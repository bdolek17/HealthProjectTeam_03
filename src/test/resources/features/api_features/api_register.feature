Feature: User Registeration
  @ApiUserRegister
  Scenario: TC User Registrations
    Given user sets the request specification
    When user sends POST request to "register" gets the response
    Then user verifies status code is 200