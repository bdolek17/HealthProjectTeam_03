@TC001_Staff_appointment
Feature: Staff Appointment
Scenario: Update appointments
Given staff is on "https://medunna.com/" page
When staff clicks on the account menu icon on home page
And staff clicks on the sign in link on login page
And staff enters the username "staff.t03" on login page
And staff enters the password "Team03+" on login page
And staff clicks on sign in button on login page
  And staff clicks on My Pages icon on home page
  And staff clicks on search Patient
  And staff enters SSN: "700-01-1111" on the box
  And staff clicks on Show Appointments
  And staff clicks on Edit
And staff clicks on start date time
  And staff enters an appointment start date time: "3022-03-19"
  And staff enters an appointment end date time: "3022-03-19"
  And staff can select status as "UNAPPROVED" , "PENDING" , "CANCELLED" but can not select as "COMPLETED"
  And staff can select the doctor
  And staff can click to Save button

  @TC002_Update_appointment
  Scenario: Test view result
    Given staff is on "https://medunna.com/" page
    And staff clicks on My Pages icon on home page
    And staff clicks on search Patient
    And staff enters SSN: "700-01-1111" on the box again
  And staff clicks on Show Appointments again
  And staff clicks Show Test button
  And staff clicks on  View Result
