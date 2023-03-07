@US07_Editable_Fields @edit_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_TC004_DB_firstname_verification #for US07_TC002
  @FirstNameUpdateTest
  Scenario Outline: TC004-Verification of firstname (DB)
    Given connect to medunna database
    And get all records from "jhi_user" with the "*" columns where "login" column has "<TC004_username>" value
    And  verify resultset "first_name" column contains "<TC004_firstname>" data
    Then close the database connection
    Examples: User Info
      | TC004_username  | TC004_firstname     |
      | patient03.t03   | Patient-03-updated  |


  @US07_TC008_DB_lastname_verification #for US07_TC006
  Scenario Outline: TC008-Verification of firstname (DB)
    Given connect to medunna database
    And get all records from "jhi_user" with the "*" columns where "login" column has "<TC008_username>" value
    And  verify resultset "last_name" column contains "<TC008_lastname>" data
    Then close the database connection
    Examples: User Info
      | TC008_username  | TC008_lastname |
      | patient03.t03   | Hasta-updated  |
