@Api_US06
Feature: Api_US06_Feature
  Scenario: :TC01_Post_Appointment
    Given the users sends POST requests to the "https://medunna.com/api/appointments/request"
    Then Http Status Codde should bee 201
    Then userss can create new account successfully
