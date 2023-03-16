@US10_Staff_Patient_Actions_Api
Feature: (Staff role) Staff should View and update test results of Patients,validate them using API and DB
  As a <staff>,
  I want to view patient test results,
  so that I can view and edit them

  @US23_TC05_API  #Verification for @US23_TC04 - PASS
  Scenario Outline: TC05-Test Result Update verification (API)
    Given user sets the request specification
    When user sends GET request to "c-test-results" with "<test_results_item_id>" id as spec param and gets the response
    Then user verifies that status code is 200 and test results item informations have "<result>" "<description>" values
    Examples: Test Result Info
      | test_results_item_id | result           | description           |
      | 19260                | Result For 19260 | Description For 19260 |
      | 19261                | Result For 19261 | Description For 19261 |

  @US23_TC08_API  #Verification for @US23_TC07 - FAIL
  Scenario Outline: TC08-Date Update verification should be done by (API)
    Given user sets the request specification
    When user sends GET request to "c-test-results" with "<test_results_item_id>" id as spec param and gets the response
    Then user verifies that status code is 200 and test results item informations have "<result_date>" "<result_time>" values for test result date
    Examples: Test Result Info
      | test_results_item_id | result_date | result_time  |
      | 19260                | 2023-03-15    | 14:25      |
      | 19261                | 2023-01-16    | 11:12      |

  @US23_TC11_API  #Verification for @US16_TC10 - FAIL
  Scenario Outline: TC11-Created Date Update verification should be done by (API)
    Given user sets the request specification
    When user sends GET request to "c-test-results" with "<test_results_item_id>" id as spec param and gets the response
    Then user verifies that status code is 200 and test results item informations have "<created_date>" "<created_time>" values for test result date
    Examples: Test Result Info
      | test_results_item_id | created_date | created_time |
      | 19260                | 2023-03-17   | 19:19        |
      | 19261                | 2023-02-10   | 09:12        |