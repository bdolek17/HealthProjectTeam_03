@US17_Api
Feature: US17_Room_Creation
  Scenario: US17_Post_Request
    Given ML Given the user sends POST requests to the "https://medunna.com/api/rooms"
    Then ML user gets the room data and validates