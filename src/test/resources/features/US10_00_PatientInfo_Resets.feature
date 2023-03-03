@US10_Staff_Patient_Data_Resets
Feature: (Staff role) Staff should View, edit and delete Patient information Validate them using API and DB
  As a <staff>,
  I want to view patient informations,
  so that I can View, edit and delete Patient information
  @US10_TC010_ResetPatientUpdates
  Scenario: TC10_Resetting Patient Update
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
    And Staff clicks patients edit button with the ssn "333-33-5331" on the page
    Then Verify that staff is on patient information edit page
    And Staff enters the userid "5970" on edit page
    And Staff enters the firstname "Patient-03" on edit page
    And Staff enters the lastname "Hasta" on edit page
    And Staff enters the birthdate "01011978" on edit page
    And Staff enters the email "patient03.t03@medunna.com" on edit page
    And Staff enters the phone "226-226-2626" on edit page
    And Staff enters the gender "MALE" on edit page
    And Staff enters the bloodgroup "A+" on edit page
    And Staff enters the address "Address" on edit page
    And Staff enters the description "Description" on edit page
    And Staff enters the user "system" on edit page
    And Staff enters the country "Turkey" on edit page
    And Staff enters the city_state "Ankara" on edit page
    Then Staff clicks save button

  @US10_TC002_API_PatientUpdateRest
  Scenario: TC002-Patient Resrt (API)
    Given user sets the request specification
    When user sends PUT request to "patients" gets the response
      |adress       |Adres                       |
      |birthDate    |1978-01-01T09:45:00Z       |
      |bloodgroup   |Apositive                  |
      |country      |Canada                     |
      |state_city   |Waterloo                   |
      |description  |none                       |
      |email        |patient03.t03@medunna.com  |
      |firstname    |Patient-03                 |
      |gender       |MALE                       |
      |id           |5990                       |
      |lastname     |Hasta                      |
      |phone        |226-226-2626               |
      |ssn          |333-33-5331                |
      |user         |patient03.t03              |