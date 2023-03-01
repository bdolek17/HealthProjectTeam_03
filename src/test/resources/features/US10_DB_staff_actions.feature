@US10_Staff_Patient_Actions_DB
Feature: (Staff role) Staff should View, edit and delete Patient information Validate them using API and DB
  As a <staff>,
  I want to view patient informations,
  so that I can View, edit and delete Patient information

  @US10_TC003_DB_patient_verification
  Scenario: TC003-Patient verification (DB)
    Given connect to medunna database
    And get record from "patient" with the "*" columns where "id" column has "5990" value
    Then verify resultset "email" column has "patient03.t03@medunna.com" value


  @US10_TC006_DB_patient_verification_by_ssn #for @US10_TC004
  Scenario: TC006-Patient verification (DB)
    Given connect to medunna database
    And get patient record from database where "ssn" column has "333-33-5331" value
    Then verify resultset "email" column has "patient03.t03@medunna.com" value


  @US10_TC009_DB_patient_update_verification_by_ssn #for @US10_TC007
  Scenario: TC006-Patient verification (DB)
    Given connect to medunna database
    And get patient record from database where "ssn" column has "333-33-5331" value
    Then verify resultset has following values
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