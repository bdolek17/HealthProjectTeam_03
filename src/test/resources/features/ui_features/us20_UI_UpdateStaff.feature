@US_20_UpdateStaff
    Feature: Admin can update/delete staff information
      Scenario: update_registered_staff_information
        Given Admin goes on "https://medunna.com" page
        Then Admin click on sign in button on login page
        And Admin enters "admin_username" in username field
        And Admin enters "admin_password" in password field
        And Admin clicks sign in submit button
        And clicks on "Items&titles"
        Then Admin clicks "staff" from dropdown
        Then clicks on "edit"
        Then clicks on "use search" and enter the registered "SSN"
        And verify all information on the page
        And return "staff"page and clicks on edit from one of the registered staff
        And Admin clicks on delete and delete the staff

