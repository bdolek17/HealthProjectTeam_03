@US16_PatientCreationAutherization
Feature: (Create or Edit Patient by just Admin, Validate with API)
  As an <admin>,
  I want to view my patient create and edit page,
  so that Only I can create patient.

  @US16_TC01
  Scenario: US16_TC01 [Create or edit a Patient] should only be accessible by the admin
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "AdminTeam03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    And user click on ItemsAndTitles menu
    And user verifies admin patient menu is visible
    And user click on admin patient menu
    Then user verifies that all patients page is opened
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page

  @US16_TC02
  Scenario Outline: US16_TC02 [Create or edit a Patient] should not be accessible by the staff or doctor user
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<username>" on login page
    And user enters the password "<password>" on login page
    And user clicks on sign in button on login page
    And user verifies admin items and titles menu is not visible
    And user goes on "https://medunna.com/patient" page
    Then user verifies that "You are not authorized to access this page." message on the page
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: test_data
      | username      | password   |
      | staff03.t03   | Team03+    |
      | doctor03.t03  | Team03+    |
      #| patient03.t03 | Team03+    |

  @US16_TC03
  Scenario: US16_TC03 Admin user should see all patient informations such as; SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and state / City
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "AdminTeam03" on login page
    And user enters the password "Team03+" on login page
    And user clicks on sign in button on login page
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    Then user verifies that he or she has seen all the patient informations on the page
      |ID|
      |SSN|
      |First Name|
      |Last Name|
      |Birth Date|
      |Phone|
      |Email|
      |Gender|
      |Blood Group|
      |Address|
      |Description|
      |Created Date|
      |User|
      |Country|
      |State/City|

  @US16_TC04
  Scenario: US16_TC04 When CREATING a patient, admin user should have following field (First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and state / City)
    Given user is on medunna home page
    When user logs in as admin with the username as "AdminTeam03" and password as "Team03+" to web app
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    And user click on Create a new patient button
    Then user verifies that "create" patient process page has necessery input items
    And wait 5 seconds and close the browser

  @US16_TC05
  Scenario: US16_TC05 When EDITING a patient, admin user should have following field (First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and state / City)
    Given user is on medunna home page
    When user logs in as admin with the username as "AdminTeam03" and password as "Team03+" to web app
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    And user clicks first patient edit button on the page
    Then user verifies that "edit" patient process page has necessery input items
    And wait 5 seconds and close the browser

  @US16_TC06
  Scenario: US16_TC06 Admin should be able to create new patient
    Given user is on medunna home page
    When user logs in as admin with the username as "AdminTeam03" and password as "Team03+" to web app
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    And user click on Create a new patient button
    And user enters patient information
      | firstname       | lastname  | birthdate  | birthtime  | email                     | phone          | gender | bloodgroup| address   | description     | user    | country   | state_city|
      | PatientBySA-01  | Success-01| 01011978   | 1422       |patientbysa01@medunna.com  | 111-111-1111   | FEMALE | AB-       | Adres 01  |  Description01  | system  |USA        | TEXAS     |
    Then user clicks on patient save button
    Then verify that creation succeded message and log patient id to text file

  @US16_TC07_API   #API Verification For US16_TC06
  Scenario Outline: US16_TC07 Verify Created Patient by API
    Given user sets the request specification
    When user sends GET request to "patients" with created id as spec param and gets the response
    Then user verifies that status code is 200 and patient informations have created id and following "<TC07_firstname>" "<TC07_lastname>" "<TC07_email>" "<TC07_phone>" "<TC07_gender>" values
    Examples: Patient Info
      | TC07_firstname  | TC07_lastname  |  TC07_email                | TC07_phone     | TC07_gender |
      | PatientBySA-01  | Success        | patientbysa01@medunna.com  | 111-111-1111   | FEMALE      |

  @US16_TC08_DB   #DB Verification For US16_TC06
  Scenario: US16_TC08 Verify Created Patient by DB
    Given connect to medunna database
    And get record from "patient" with the "*" columns where "id" column has created id value
    Then verify resultset fallowing values
      | firstname       | lastname       |  email                     | phone          | gender |
      | PatientBySA-01  | Success        | patientbysa01@medunna.com  | 111-111-1111   | FEMALE      |
    And close the database connection

  @US16_TC09
  Scenario: US16_TC07 Admin should not be able to create new patient without state value
    Given user is on medunna home page
    When user logs in as admin with the username as "AdminTeam03" and password as "Team03+" to web app
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    And user click on Create a new patient button
    And user enters patient information without State information
      | firstname       | lastname  | birthdate  | birthtime  | email                   | phone          | gender | bloodgroup| address | description   | user    | country   | state_city|
      | PatientBySA-02  | Success-02| 01011972   | 1011       |patientbysa02@medunna.com  | 222-222-2222 | MALE   | A+        | Adres 02|  Description  | system  |USA        |           |
    #And user clicks on patient save button
    Then verify that page url is still "https://medunna.com/patient/new"

  @US16_TC10
  Scenario: US16_TC08 Admin can be able to delete any patient
    Given user is on medunna home page
    When user logs in as admin with the username as "AdminTeam03" and password as "Team03+" to web app
    And user click on ItemsAndTitles menu
    And user click on admin patient menu
    And user clicks patient delete button with id 1254
    Then user verifies deleted message
    #And wait 5 seconds and close the browser

  @US16_TC11_API   #API Verification For US16_TC10
  Scenario: US16_TC07 Verify Created Patient by API
    Given user sets the request specification
    When user sends GET request to "patients" with id 21769 as spec param and gets the response
    Then user verifies status code is 404


  @US16_TC12_DB   #DB Verification For US16_TC10
  Scenario: US16_TC08 Verify Created Patient by DB
    Given connect to medunna database
    And get record from "patient" with the "*" columns where "id" column has 21769 id value
    Then verify resultset is empty



  @DeleteCreatedPatients
  Scenario: Delete All Created Patients by Using Text File
    #Given user sets the request specification
    When user sends DELETE request to "patients" to delete all created patients and gets the response



