@Doctor_Patient_info
Feature: Doctor
  Scenario: Doctor
    Given the doctor goes on "https://medunna.com" pagepage
    When the doctor click on the account menu icon on home pagepage
    And the doctor clicks on the sign in link on home pagepage
    And the doctor enter the username "doctor.t03" on login pagepage
    And the doctor enter the password "Team03+" on login page
    Then the doctor click on sign in button on login pagepage

    Scenario: Doctor_Patient_Info
      When the doctor click inpatient on doctor pagepage
      And the doctor should see patient info on doctor pagepage
      And the doctor edit patient info on doctor pagepage
      And the doctor should edit status info on doctor pagepage
      And the doctor should edit patient room info on doctor pagepage




