@US10_Staff_Patient_Actions
Feature: (Staff role) Staff should View and update test results of Patients,validate them using API and DB
  As a <staff>,
  I want to view patient test results,
  so that I can view and edit them

  @US23_TC01
  Scenario: TC01 user (Staff) can search about patient by SSN id
    Given user is on medunna home page
    When user logs in with the username as "staff03.t03" and password as "Team03+" to web app
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    And user enters the ssn "333-33-5331" on patient search page
    Then Verify that patient found and has information as "5990" "333-33-5331" "Patient-03" "Hasta"
    And wait 5 seconds and close the browser

  @US23_TC02
  Scenario: TC02 User(staff) should navigate to Show appointments, edit patient tests clicking on Show test
            click on view results, edit results where they will see selected tests by Doctor and they will provide results by numbers (60, 70 etc..)
    Given user is on medunna home page
    When user logs in with the username as "staff03.t03" and password as "Team03+" to web app
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    And user enters the ssn "333-33-5331" on patient search page
    And Verify that patient has been found with patient id "5990"
    And user clicks on Show Appointments button
    And user clicks on Show Tests button of appointment id "20468"
    And user clicks on View Results button of test id "16269"
    Then verify that test results has test items
    #And wait 5 seconds and close the browser

  @US23_TC03
  Scenario: TC03 Staff will view the result info such as Date, Result, description, Created date etc..
    Given user is on medunna home page
    When user logs in with the username as "staff03.t03" and password as "Team03+" to web app
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    Then user views test results page for the patient with ssn id "333-33-5331" and appointment id "20468" and test id "16269"
    Then user verifies that test results page has items such as "ID" "Name" "Result" "Test" for the patient
    #And wait 5 seconds and close the browser

  @US23_TC04
  Scenario Outline: TC04 Staff will update for the Result and description fields
    Given user is on medunna home page
    When user logs in with the username as "staff03.t03" and password as "Team03+" to web app
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    And user views test results page for the patient with ssn id "<patient_ssn>" and appointment id "<appointment_id>" and test id "<test_id>"
    And user clicks on Edit button of Test Results Item with id "<test_results_item_id>"
    And user enters valid data for Result "<result>" and "<description>" description
    And user clicks Save button
    Then verify that a succussfully saves message with text "A Test Result is updated with identifier" for Test Results Item with id "<test_results_item_id>"
    #And wait 5 seconds and close the browser
    Examples: Patient Info
      | patient_ssn    | appointment_id | test_id  | test_results_item_id | result_date  | result_time | result           | description           | created_date |created_time|
      | 333-33-5331    | 20468          | 16269    | 19260                | 20230315     | 1425        | Result For 19260 | Description For 19260 | 20230314     |0912        |
      | 333-33-5331    | 20468          | 16269    | 19261                | 20230315     | 1425        | Result For 19261 | Description For 19261 | 20230314     |0912        |

  @US23_TC05_API  #Verification for @US16_TC04
  Scenario Outline: TC05-Test Result Update verification (API)
    Given user sets the request specification
    When user sends GET request to "c-test-results" with "<test_results_item_id>" id as spec param and gets the response
    Then user verifies that status code is 200 and test results item informations have "<result>" "<description>" values
    Examples: Test Result Info
      | test_results_item_id | result           | description           |
      | 19260                | Result For 19260 | Description For 19260 |
      | 19261                | Result For 19261 | Description For 19261 |

  @US23_TC06_DB # Verification for US23_TC04
  Scenario Outline: TC06-Test Result Update verification (DB)
    Given connect to medunna database
    And get all records from "c_test_result" with the "*" columns where "id" column has "<test_results_item_id>" value
    And  verify resultset "result" column contains "<result>" data
    And  verify resultset "description" column contains "<description>" data
    Then close the database connection
    Examples: Test Result Info
      | test_results_item_id | result           | description           |
      | 19260                | Result For 19260 | Description For 19260 |
      #| 19261                | Result For 19261 | Description For 19261 |