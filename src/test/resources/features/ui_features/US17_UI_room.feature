
@US17_UI_Create
Feature: Room

  Scenario: Room_Create
    Given  ML Admin Navigate to url "https://medunna.com/"
    And  ML Admin Click on account icon
    Then  ML Admin Click on Sign in
    And  ML Admin Click on "AdminTeam03" input box and enter valid Username
    And  ML Admin Click on "Team03+"  input box and enter valid Password
    And  ML Admin Click on Sign in button
    And  ML Admin Click on Items&Titles
    And  ML Admin Select Room from drop down menu and click
    And  ML Admin Click on Create a new Room
    And  ML Admin Click on Room Number box and enter room number
    And  ML Admin Click on Room Type box and select room type
    And  ML Admin Click on Status
    And  ML Admin Click on Price box and enter price
    And  ML Admin Click on Description box and enter description
    And  ML Admin Click on date corresponds to the day created
    And  ML Admin Click on Save
    And  ML Admin Verify that  A new Room is created is visible
    And  ML Admin Click on account menu
    Then  ML Admin Click Sign out



  #Scenario: TC_01 The admin should create new room

    #And  AdminClick on Create a new Room
    #And  Admin Verify that Create or edit a Room is visible
    #And  Admin Click on account menu
    #Then  Admin Click Sign out


  #Scenario: TC_01 Admin can view all rooms with same items

   # And  Admin Click on Room Type
    #And  Admin Verify that Twin type rooms is visible
    #And  Admin Click on account menu
    #Then  Admin Click Sign out


  @US17_Delete
  Scenario: TC_02_The admin should view all rooms, update existing rooms and delete rooms

    Given  ML Admin Navigate to url "https://medunna.com/" page
    And  ML Admin Click on account icon page
    Then  ML Admin Click on Sign in page
    And  ML Admin Click on "AdminTeam03" input box and enter valid Username page
    And  ML Admin Click on "Team03+"  input box and enter valid Password page
    And  ML Admin Click on Sign in button page
    And  ML Admin Click on Items&Titles page
    And  ML Admin Select Room from drop down menu and click page
    And  Admin Click on Edit and update rooms
    And  Admin Click on Room Number box, delete information and enter room number
    And  Admin Click on Room Type box and change room type
    And  Admin Click on Status
    And  Admin Click on Price box, delete information and enter price
    And  Admin Click on Description box,delete information and enter description
    And  Admin Click on Save button
    And  Admin Verify that updated successfully
    And  Admin Click on Delete
    And  Admin Click on Delete in alert window
    And  Admin Verify that deleted successfully
    And  Admin Click on account menu
    Then  Admin Click Sign out





