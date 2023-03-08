@US06_UI
  Feature: Appointment
    Scenario: Make_Appointment
      Given The user click on "https://medunna.com" appointment pagess
      When The user enter firstname for appointment
      And The user enter lastname for appointment
      And The user enter SSN for appointment
      And The user enter email for appointment
      And The user enter phone for appointment
      And The user clicks send an appointment request button
      Then The user should see appointment registration saved message

      Scenario: Appointment_with_invalidSSN
        Given The user click on "https://medunna.com" appointment pagess
        When The user enter firstname for appointment
        And The user enter lastname for appointment
        And 4--The user enter invalidSSN
        And 5-The user should error message












