@US10_Staff_Patient_Actions
Feature: (Staff role) Staff should View and update test results of Patients,validate them using API and DB
  As a <staff>,
  I want to view patient test results,
  so that I can view and edit them

  Background: Staff Logs on Medunna
    Given user is on medunna home page
    When user logs in with the username as "staff.t03" and password as "Team03+" to web app
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page

  @US23_TC01
  Scenario: TC01 user (Staff) can search about patient by SSN id
    When user enters the ssn "333-33-5331" on patient search page
    Then Verify that patient found and has information as "5990" "333-33-5331" "Patient-03" "Hasta"
    And wait 5 seconds and close the browser

  @US23_TC02
  Scenario: TC02 User(staff) should navigate to Show appointments, edit patient tests clicking on Show test
            click on view results, edit results where they will see selected tests by Doctor and they will provide results by numbers (60, 70 etc..)
    When user enters the ssn "333-33-5331" on patient search page
    And user clicks on Show Appointments button of patient with patient id "5990"
    And user clicks on Show Tests button of appointment id "20468"
    And user clicks on View Results button of test id "16269"
    Then verify that test results has test items
    And wait 5 seconds and close the browser

  @US23_TC03
  Scenario Outline: TC03 Staff will view the result info such as Date, Result, description, Created date etc..
    When user enters the ssn "<patient_ssn>" on patient search page
    And user clicks on Show Appointments button of patient with patient id "<patient_id>"
    And user clicks on Show Tests button of appointment id "<appointment_id>"
    And user clicks on View Results button of test id "<test_id>"
    And user clicks on Edit button of Test Results Item with id "<test_results_item_id>"
    Then user verifies that Create or edit a Test Result is displayed
    And wait 5 seconds and close the browser
    Examples: Patient Info
      | patient_ssn    | patient_id  | appointment_id | test_id  | test_results_item_id | result_date  | result_time | result           | description           | created_date |created_time|
      | 333-33-5331    | 5990        | 20468          | 16269    | 19260                | 20230315     | 1425        | Result For 19260 | Description For 19260 | 20230314     |0912        |

  @US23_TC04
  Scenario Outline: TC04 Staff will update for the Result and description fields
    When user enters the ssn "<patient_ssn>" on patient search page
    And user clicks on Show Appointments button of patient with patient id "<patient_id>"
    And user clicks on Show Tests button of appointment id "<appointment_id>"
    And user clicks on View Results button of test id "<test_id>"
    And user clicks on Edit button of Test Results Item with id "<test_results_item_id>"
    And user enters valid data for Result "<result>" and "<description>" description
    And user clicks Save button
    Then verify that a successfully saves message with text "A Test Result is updated with identifier" for Test Results Item with id "<test_results_item_id>"
    And wait 5 seconds and close the browser
    Examples: Patient Info
      | patient_ssn    | patient_id  | appointment_id | test_id  | test_results_item_id | result_date  | result_time | result           | description           | created_date |created_time|
      | 333-33-5331    | 5990        | 20468          | 16269    | 19260                | 20230315     | 1425        | Result For 19260 | Description For 19260 | 20230314     |0912        |
      | 333-33-5331    | 5990        | 20468          | 16269    | 19261                | 20230315     | 1425        | Result For 19261 | Description For 19261 | 20230314     |0912        |

  @US23_TC07
  Scenario Outline: TC07 Staff can update the Date
    When user enters the ssn "<patient_ssn>" on patient search page
    And user clicks on Show Appointments button of patient with patient id "<patient_id>"
    And user clicks on Show Tests button of appointment id "<appointment_id>"
    And user clicks on View Results button of test id "<test_id>"
    And user clicks on Edit button of Test Results Item with id "<test_results_item_id>"
    And user enters valid data for Date "<result_date>" and "<result_time>" time
    And user clicks Save button
    Then verify that a successfully saves message with text "A Test Result is updated with identifier" for Test Results Item with id "<test_results_item_id>"
    And wait 5 seconds and close the browser
    Examples: Patient Info
      | patient_ssn    | patient_id  | appointment_id | test_id  | test_results_item_id | result_date  | result_time | result           | description           | created_date |created_time|
      | 333-33-5331    | 5990        | 20468          | 16269    | 19260                | 20230315     | 1425        | Result For 19260 | Description For 19260 | 20230314     |0912        |
      | 333-33-5331    | 5990        | 20468          | 16269    | 19261                | 20230116     | 1112        | Result For 19261 | Description For 19261 | 20230314     |0912        |


  @US23_TC10
  Scenario Outline: TC10 Staff will update the Created Date
    When user enters the ssn "<patient_ssn>" on patient search page
    And user clicks on Show Appointments button of patient with patient id "<patient_id>"
    And user clicks on Show Tests button of appointment id "<appointment_id>"
    And user clicks on View Results button of test id "<test_id>"
    And user clicks on Edit button of Test Results Item with id "<test_results_item_id>"
    And user enters valid data for Created Date "<created_date>" and "<created_time>" Created time
    And user clicks Save button
    Then verify that a successfully saves message with text "A Test Result is updated with identifier" for Test Results Item with id "<test_results_item_id>"
    And wait 5 seconds and close the browser
    Examples: Patient Info
      | patient_ssn    | patient_id  | appointment_id | test_id  | test_results_item_id | result_date  | result_time | result           | description           | created_date |created_time|
      | 333-33-5331    | 5990        | 20468          | 16269    | 19260                | 20230315     | 1425        | Result For 19260 | Description For 19260 | 2023-03-17     |19:19     |
      | 333-33-5331    | 5990        | 20468          | 16269    | 19261                | 20230315     | 1425        | Result For 19261 | Description For 19261 | 2023-02-10     |09:12     |

