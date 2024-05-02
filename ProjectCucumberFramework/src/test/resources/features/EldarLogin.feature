@regression @smoke @EldarLogin
  Feature: Login function

    @login
    Scenario: Validate Login
      Given user navigates to EldarApp
      When user logs in with username "student1@mindtekbootcamp.com" and password "mindtek109"

      And user clicks on Company List icon
      And user clicks on Add Company button