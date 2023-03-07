@US10_Staff_Patient_Actions
Feature: (Staff role) Staff should View, edit and delete Patient information Validate them using API and DB
  As a <staff>,
  I want to view patient informations,
  so that I can View, edit and delete Patient information

  @US10_TC001
  Scenario: TC01_User(staff) should view patient information in "My Pages" navigating to View portal
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
    And Staff clicks first patient view button on the page
    Then Verify that staff is patient information page and views patient informations


  @US10_TC004
  Scenario: TC04_User can search for a new applicant by their SSN and see all their registration info populated
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
    And Staff clicks patients view button with the ssn "333-33-5331" on the page
    Then Verify that staff is patient information page and views patient informations



  @US10_TC007
  Scenario Outline: TC07_User can edit all patient information such as; 'id, firstname, lastname, birthdate, email, phone, gender, blood group, address, description, user, country and state/city
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
    And Staff enters the userid "<TC007_id>" on edit page
    And Staff enters the firstname "<TC007_firstname>" on edit page
    And Staff enters the lastname "<TC007_lastname>" on edit page
    And Staff enters the birthdate "<TC007_birthdate>" on edit page
    And Staff enters the email "<TC007_email>" on edit page
    And Staff enters the phone "<TC007_phone>" on edit page
    And Staff enters the gender "<TC007_gender>" on edit page
    And Staff enters the bloodgroup "<TC007_bloodgroup>" on edit page
    And Staff enters the address "<TC007_address>" on edit page
    And Staff enters the description "<TC007_description>" on edit page
    And Staff enters the user "<TC007_user>" on edit page
    And Staff enters the country "<TC007_country>" on edit page
    And Staff enters the city_state "<TC007_state_city>" on edit page
    Then Staff clicks save button
    And user clicks on the my pages menu link on home page
    And user clicks on the search patient link on home page
    And Verify that staff in patients page
    And Staff clicks search input box
    And Staff enters patient "333-33-5331" number to find patient
    And Verify that patient found
    And Staff clicks patients edit button with the ssn "333-33-5331" on the page
    Then Verify that staff is on patient information edit page
    And Verify patient information datas "<TC007_id>" "<TC007_firstname>" "<TC007_lastname>" "<TC007_birthdate>" "<TC007_email>" "<TC007_phone>" "<TC007_gender>" "<TC007_bloodgroup>" "<TC007_address>" "<TC007_description>" "<TC007_user>" "<TC007_country>" "<TC007_state_city>" on edit page
    Examples: Patients Info
      | TC007_id | TC007_firstname  | TC007_lastname | TC007_birthdate      | TC007_email                 | TC007_phone    | TC007_gender | TC007_bloodgroup| TC007_address | TC007_description| TC007_user| TC007_country| TC007_state_city|
      #| 59701     | XPatient-03      | XHasta         | 02021977 | Xpatient03.t03@medunna.com  | 555-444-3322   | OTHER        | AB+             | XAdres        |  Xdescription    |  system    |Canada       |Waterloo         |
      | 5990      | Patient-03      | Hasta           | 01011978 | patient03.t03@medunna.com   | 226-226-2626   | MALE         | A+              | Adres         |  Description     |  system    |Turkey       |Waterloo         |







