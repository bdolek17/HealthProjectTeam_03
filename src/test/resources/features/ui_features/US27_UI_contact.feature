@contact
  Feature: US27 contact
    Scenario: US27_contact
      Given The user goes to "https://medunna.com" home page..
      And The user clicks contact button..
      And The user enter name..
      And The user enter email..
      And The user enter subject.
      And The user enter message.
      And The user clicks send button.
      And The user should see "Your message has been received".

    Scenario: US27_contact_negative
      Given The user goes to "https://medunna.com" home page..
      And The user clicks contact button..
      And The user does not enter name..
      Then The user should see error message








