@Api_US11
  Feature: Api_US11_Feature
    Scenario: :TC02_Get_Appointments
      Given the doctor sends GET requests to the "health_project_url"
      Then Http Status Code should be 200
      Then doctor can see their appointments list and time slots
      Then the doctor can see patient id, start date, end date, status...