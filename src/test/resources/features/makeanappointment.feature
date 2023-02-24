@login_patient
  Feature:
     Scenario: Login_Patient
       Given user is on "https://medunna.com/" page
       When user clicks on the account menu icon on home page
       And user clicks on the sign in link on login page
       And user enters the username "elifkaya" on login page
       And user enters the password "442500Ek!" on login page
       And user clicks on sign in button on login page
       @make_appointment
       Scenario: Make_Appointment
         When user click on my pages
         And user click make an appointment
         And user enters the phone "4379945931"
         And user enters date "2023-03-28"
         And user clicks send a request button
