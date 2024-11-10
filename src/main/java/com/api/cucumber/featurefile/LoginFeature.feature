Feature: Gibberish Streaming service Login

Background: User login scenario
  Given The user is at the login page

Scenario Outline: User login
  When the user with the following username and password
      | UserName1 | Password1 |
      | UserName2 | Password2 |
      | UserName3 | Password3 |
      | UserName4 | Password4 |
  Then User should be able to login with correct username and password
