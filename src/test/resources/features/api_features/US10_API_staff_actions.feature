@US10_Staff_Patient_Actions_API
Feature: (Staff role) Staff should View, edit and delete Patient information Validate them using API and DB
  As a <staff>,
  I want to view patient informations,
  so that I can View, edit and delete Patient information

  @US10_TC002_API_patient_verification  #for @US10_TC001
  Scenario Outline: TC002-Patient verification (API)
    Given user sets the request specification
    When user sends GET request to "patients" with "<TC002_id>" id as spec param and gets the response
    Then user verifies that status code is 200 and patient informations have "<TC002_id>" "<TC002_ssn>" "<TC002_email>" "<TC002_login>" values
    Examples: User Info
      | TC002_id | TC002_ssn    | TC002_email                 | TC002_login    |
      | 5990     | 333-33-5331  | patient03.t03@medunna.com   | patient03.t03  |


  @US10_TC005_API_patient_verification_by_ssn  #for @US10_TC004
  Scenario: TC005-Patient verification (API)
    Given user sets the request specification
    When user sends GET request to "patients/search" with "333-33-5331" query string and gets the response
    Then user verifies status code is 200
    And user verifies that patient informations have 5990 as id "patient03.t03@medunna.com" as email "patient03.t03" as login values

  @US10_TC008_API_patient_update_verification_by_ssn  #for @US10_TC007
  Scenario: TC005-Patient verification (API)
    Given user sets the request specification
    When user sends GET request to "patients" endpoint with "5990" id and gets the response
    Then user verifies status code is 200
    And user verifies the patient informations
      |adress       |none                       |
      |birthDate    |1977-02-03T09:45:00Z       |
      |bloodGroup   |Apositive                  |
      |country      |Canada                     |
      |state_city   |Waterloo                   |
      |description  |none                       |
      |email        |patient03.t03@medunna.com  |
      |firstName    |Patient-03                 |
      |gender       |MALE                       |
      |id           |5990                       |
      |lastName     |Hasta                      |
      |phone        |226-226-2626               |
      |ssn          |333-33-5331                |
      |user         |patient03.t03              |