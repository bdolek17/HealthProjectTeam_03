@US17_DB_Room
Feature: Room_DataBase
  Scenario: US17_Validate room with Data Base
    Given ML given connects to database
    When ML get all "*" as a list from "room" table
    Then ML verify "room" table "room_number" column contains 9553841
    And ML close the connection