@US07_API @check_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  Scenario: Get USer Info
    Given user sets the necessary path params for user info
    When user sends GET request and gets the response
    Then user verifies username, first