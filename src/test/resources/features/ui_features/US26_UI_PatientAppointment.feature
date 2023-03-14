@US26_UI
Feature: Patient_Appointment
  Scenario: Patient_Can_Make_a_New_Appointment
    Given ML patient is on "https://medunna.com/" page
    When ML patient clicks on the account menu icon on home page
    And ML patient clicks on the sign in link on login page
    And ML patient enters the username "patient.t03" on login page
    And ML patient enters the password "Team03+" on login page
    And ML patient clicks the sign in button
    And ML patient clicks my pages select make an appointment
    And ML patient enter first name "Emel"
    And Ml patent enter last name "Arslan"
    And ML patient enter ssn "135-25-2305"
    And ML patient enter email "emelarslan@gmail.com"
    And ML patient enter phone "6475743327"
    And ML patient enter appointment date time "2023-03-21"
    And ML patient click send an appointment request


