@US07_API @check_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_API_firstname_verification
  Scenario Outline: Verification of firstname
    Given user sets the necessary path params with "<SSN>" for user info
    When user sends GET request and gets the response
    Then user verifies then firstname field has "<firstname>" value
    Examples: User Info
      | TC006_ssn       | TC006_firstname |
      | staff03.t03         | Patient-03-updated  |