@TC01_StaffCreation
Feature: Staff Creation


  Scenario Outline: TC01_Post_Request_Staff_Creation

    Given admin sends post request for staff creation "https://medunna.com/api/staff"
    Then admin gets the staff data and validates
    And user sets the expected data "<firstname>", "<lastname>" "<phone>" "<activated>" "<login>" and  "<SSN>"
    And user sends the POST request and gets the response body
    Then user validates api records data

    Examples: API test data
      | firstname | lastname | phone    | activated | login | SSN         |
      | Kazim  | Koyuncu  | 3453453456 | true      | okey  | 222-66-2224 |

