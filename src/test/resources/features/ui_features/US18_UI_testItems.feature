@US18_testItems
  Feature: Admin create/delete/edit test items
    Scenario: US18_test_itesms
      Given Admin goes on "https://medunna.com" page..
      Then Admin click on sign in button on login page..
      And Admin enters "AdminTeam03" ..
      And Admin enters "Team03+" .
      And Admin clicks sign in submit button..
      And clicks on "Items&titles" ..
      And Admin clicks "test&items" from dropdown..
      And Admin clicks create a new test item button..
      And Admin enters his-her name
      And Admin enters description
      And Admin enters price
      And Admin enters default min value
      And Admin enters default max value
      And Admin clicks save button
      And Admin should see created message
      And Admin clicks view button
      Then Admin should see view page
      And Admin clicks edit button
      Then Admin should see create or edit test item
      And Admin edits description
      And Admin clicks save button..
      And Admin clicks delete button
      And Admin  clicks delete button again on the small box
      Then Admin shouldn't see data on this page