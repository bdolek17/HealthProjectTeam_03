@US07_API @check_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_API_firstname_verification
  Scenario Outline: Verification of firstname
    Given user sets the necessary path params with "<TC006_ssn>" for user info
    When user sends GET request and gets the response
    Then user verifies then firstname field has "<TC006_firstname>" value
    Examples: User Info
      | TC006_ssn       | TC006_firstname |
      | 333-33-5331         | Patient-03-updated  |