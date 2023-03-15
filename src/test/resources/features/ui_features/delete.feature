Feature: Delete Islemi
  @US20_Delete
  Scenario: Delete
    Given Admin goes on "https://medunna.com" page
    Then Admin click on sign in button on login page
    And Admin enters "AdminTeam03" in username field
    And Admin enters "Team03+" in password field
    And Admin clicks sign in submit button
    And clicks on "Items&titles"
    Then Admin clicks "staff" from dropdown
    #And Admin clicks firt staff delete button