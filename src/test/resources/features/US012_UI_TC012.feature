@edit
  Feature: Edit



Scenario: Edit_As_doctor
Given user is a on "https://medunna.com" page
When user clicks on the account menu icon on home page
And user clicks on the sign in link on login page
And user enters the username "doctor.t03" on login page
And user enters the password "Team03+" on login page
And user clicks on sign in button on login page
And user clicks on the my pages menu icon on home page
And user chooses "My Appointments" from dropdow
      And user enter the dates to see appointments
And user should click on edit button.
And user type in Anamnesis
And user type in Treatment
And user type in Diagnosis
 And user chose status
Then user click on save button