@dr_login_appointments
Feature: dr_appointments
Scenario: Login_As_doctor
Given user goes on "https://www.medunna.com/" page
When user click on the account menu icon on home page
And user click on the sign in link on login page
And user enter the username "doctor.t03" on login page
And user enter the password "Team03+" on login page
And user click on sign in button on login page
