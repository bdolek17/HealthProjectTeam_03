@US10_Staff_Patient_Actions_Db
Feature: (Staff role) Staff should View and update test results of Patients,validate them using API and DB
  As a <staff>,
  I want to view patient test results,
  so that I can view and edit them

  @US23_TC06_DB # Verification for US23_TC04 - PASS
  Scenario Outline: TC06-Test Result Update verification (DB)
    Given connect to medunna database
    And get all records from "c_test_result" with the "*" columns where "id" column has "<test_results_item_id>" value
    And  verify resultset "result" column contains "<result>" data
    And  verify resultset "description" column contains "<description>" data
    Then close the database connection
    Examples: Test Result Info
      | test_results_item_id | result           | description           |
      | 19260                | Result For 19260 | Description For 19260 |
      | 19261                | Result For 19261 | Description For 19261 |


  @US23_TC09_DB # Verification for US23_TC09 - FAIL
  Scenario Outline: TC09-Date Update verification should be done by (DB)
    Given connect to medunna database
    And get all records from "c_test_result" with the "*" columns where "id" column has "<test_results_item_id>" value
    And  verify resultset "date" column contains "<result_date>" and "<result_time>" data
    Then close the database connection
    Examples: Test Result Info
      | test_results_item_id | result_date | result_time  |
      | 19260                | 2023-03-15    | 14:25      |
      | 19261                | 2023-01-16    | 11:12      |


  @US23_TC12_DB # Verification for US23_TC10 - FAIL
  Scenario Outline: TC09-Date Update verification should be done by (DB)
    Given connect to medunna database
    And get all records from "c_test_result" with the "*" columns where "id" column has "<test_results_item_id>" value
    And  verify resultset "date" column contains "<created_date>" and "<created_time>" data
    Then close the database connection
    Examples: Test Result Info
      | test_results_item_id | created_date | created_time |
      | 19260                | 2023-03-17   | 19:19        |
      | 19261                | 2023-02-10   | 09:12        |