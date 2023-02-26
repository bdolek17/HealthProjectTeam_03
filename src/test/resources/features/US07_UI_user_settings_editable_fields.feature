@US07_Editable_Fields @edit_user_info
Feature:  (User info segment (User Settings) should be editable on Homepage)
  As a <admin,patient,staff,doctor>,
  I want to view my user informations,
  so that I can update my informations.

  @US07_TC002
  @FirstNameUpdateTest
  Scenario Outline: TC002-There should be an option to update firstname
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC002_username>" on login page
    And user enters the password "<TC002_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<TC002_updatedFirstname>" firstname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC002_username>" on login page
    And user enters the password "<TC002_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And verify firstname inputbox has "<TC002_updatedFirstname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC002_username    | TC002_password   | TC002_updatedFirstname  |
      | patient03.t03     | Team03+          | Patient-03-updated      |
      #| staff03.t03         | Team03+          | Staff-03-updated    |

  @US07_TC003_API_firstname_verification
  @FirstNameUpdateTest
  Scenario Outline: TC003-Verification of firstname (API)
    Given user sets the request specification
    When user sends GET request to "user" with "<TC003_ssn>" query string and gets the response
    Then user verifies status code is 200
    And user verifies then firstname field has "<TC003_firstname>" value
    Examples: User Info
      | TC003_ssn       | TC003_firstname |
      | 333-33-5331     | Patient-03-updated  |

  @US07_TC004_DB_firstname_verification
  @FirstNameUpdateTest
  Scenario Outline: TC004-Verification of firstname (DB)
    Given connect to medunna database
    And get all records from "jhi_user" with the "*" columns where "login" column has "<TC004_username>" value
    And  verify resultset "first_name" column contains "<TC004_firstname>" data
    Then close the database connection
    Examples: User Info
      | TC004_username  | TC004_firstname     |
      | patient03.t03   | Patient-03-updated  |


  @US07_TC005  #negative of TC002
  Scenario Outline: TC005-Firstname can not be updated with missing value
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC005_username>" on login page
    And user enters the password "<TC005_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "" firstname inputbox
    And user clicks save button
    And verify firstname is required message text visibility

    Examples: User Credentials
      | TC005_username    | TC005_password  |
      | patient03.t03     | Team03+         |
      #| staff03.t03         | Team03+        |


  @US07_TC006
  Scenario Outline: TC006-There should be an option to update lastname
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC006_username>" on login page
    And user enters the password "<TC006_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<TC006_updatedLastname>" lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    And user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC006_username>" on login page
    And user enters the password "<TC006_password>" on login page
    And user clicks on sign in button on login page
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And verify lastname inputbox has "<TC006_updatedLastname>" value
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | TC006_username    | TC006_password   | TC006_updatedLastname   |
      | patient03.t03       | Team03+          | Hasta-updated    |
      #| staff03.t03         | Team03+          | Personel-updated |

  @US07_TC007_API_firstname_verification
  Scenario Outline: TC007-Verification of firstname (API)
    Given user sets the request specification
    When user sends GET request to "user" with "<TC007_ssn>" query string and gets the response
    Then user verifies status code is 200
    And user verifies then firstname field has "<TC007_firstname>" value
    Examples: User Info
      | TC007_ssn       | TC007_firstname |
      | 333-33-5331     | Patient-03-updated  |

  @US07_TC008_DB_firstname_verification
  Scenario Outline: TC008-Verification of firstname (DB)
    Given connect to medunna database
    And get all records from "jhi_user" with the "*" columns where "login" column has "<TC008_username>" value
    And  verify resultset "last_name" column contains "<TC008_lastname>" data
    Then close the database connection
    Examples: User Info
      | TC008_username  | TC008_lastname     |
      | patient03.t03   | Hasta-updated  |

  @US07_TC009  #negative of TC006
  Scenario Outline: TC005-LastName can not be updated with missing value
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<TC009_username>" on login page
    And user enters the password "<TC009_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "" lastname inputbox
    And user clicks save button
    And verify lastname is required message text visibility
    Examples: User Credentials
      | TC009_username    | TC009_password   |
      | patient03.t03     | Team03+          |
      #| staff03.t03         | Team03+          |



  @US07_ResetUpdates
  Scenario Outline: Reset user info to original
    Given user is on medunna home page
    When user clicks on the account menu icon on home page
    And user clicks on the sign in link on home page
    And user enters the username "<reset_username>" on login page
    And user enters the password "<reset_password>" on login page
    And user clicks on sign in button on login page
    And verify user logged in
    And user clicks on the account menu icon on home page
    And user clicks on the settings link on home page
    And user enters new "<reset_firstname>" firstname inputbox
    And user enters new "<reset_lastname>" lastname inputbox
    And user clicks save button
    And user clicks on the account menu icon on home page
    And user clicks on the sign out link on home page
    Examples: User Credentials
      | reset_username  | reset_password   | reset_firstname  | reset_lastname    |
      | patient03.t03   | Team03+          | Patient-03       | Hasta             |
      | staff03.t03     | Team03+          | Staff-03         | Personel          |
      | doctor03.t03    | Team03+          | Doctor-03        | Personel          |