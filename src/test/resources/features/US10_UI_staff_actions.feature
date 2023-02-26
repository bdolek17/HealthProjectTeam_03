@US10_Staff_Patient_Actions
Feature: (Staff role) Staff should View, edit and delete Patient information Validate them using API and DB
  As a <staff>,
  I want to view patient informations,
  so that I can View, edit and delete Patient information

  @US10_TC001
  Scenario: TC01_User(staff) should view patient information in "My Pages" navigating to View portal
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "staff03.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    And Verify that staff in patients page
    And Staff clicks first patient view button on the page
    Then Verify that staff is patient information page and views patient informations

  @US10_TC002_API_patient_verification
  Scenario Outline: TC002-Patient verification (API)
    Given user sets the request specification
    When user sends GET request to "patients" with "<TC002_id>" id as spec param and gets the response
    Then user verifies that status code is 200 and patient informations have "<TC002_id>" "<TC002_ssn>" "<TC002_email>" "<TC002_login>" values
    Examples: User Info
      | TC002_id | TC002_ssn    | TC002_email                 | TC002_login    |
      | 5970     | 333-33-5331  | patient03.t03@medunna.com   | patient03.t03  |

  @US10_TC003_DB_patient_verification
  Scenario: TC003-Patient verification (DB)
    Given connect to medunna database
    And get record from "patient" with the "*" columns where "id" column has "5970" value
    Then verify resultset "email" column has "patient03.t03@medunna.com" value

  @US10_TC004
  Scenario: TC04_User can search for a new applicant by their SSN and see all their registration info populated
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "staff03.t03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    And Verify that staff in patients page
    And Staff clicks search input box
    And Staff enters patient "333-33-5331" number to find patient
    And Verify that patient found
    And Staff clicks patients view button on the page
    Then Verify that staff is patient information page and views patient informations

  @US10_TC004_API_patient_verification_by_ssn
  Scenario: TC002-Patient verification (API)
    Given user sets the request specification
    When user sends GET request to "patients/search" with "333-33-5331" query string and gets the response
    Then user verifies status code is 200
    And user verifies that patient informations have 5970 as id "patient03.t03@medunna.com" as email "patient03.t03" as login values

  @US10_TC005_DB_patient_verification_by_ssn
  Scenario: TC003-Patient verification (DB)
    Given connect to medunna database
    And get patient record from database where "ssn" column has "333-33-5331" value
    Then verify resultset "email" column has "patient03.t03@medunna.com" value