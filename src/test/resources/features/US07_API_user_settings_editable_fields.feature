@US07_Editable_Fields @edit_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_TC003_API_firstname_verification  #for US07_TC002
  @FirstNameUpdateTest
  Scenario Outline: TC003-Verification of firstname (API)
    Given user sets the request specification
    When user sends GET request to "user" with "<TC003_ssn>" query string and gets the response
    Then user verifies status code is 200
    And user verifies then firstname field has "<TC003_firstname>" value
    Examples: User Info
      | TC003_ssn       | TC003_firstname |
      | 333-33-5331     | Patient-03-updated  |

  @US07_TC007_API_firstname_verification  #for US07_TC006
  Scenario Outline: TC007-Verification of firstname (API)
    Given user sets the request specification
    When user sends GET request to "user" with "<TC007_ssn>" query string and gets the response
    Then user verifies status code is 200
    And user verifies then firstname field has "<TC007_firstname>" value
    Examples: User Info
      | TC007_ssn       | TC007_firstname |
      | 333-33-5331     | Patient-03-updated  |
