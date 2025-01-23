Feature: Login scenarios

  @invalidLogin
  Scenario: invalid admin login
    When user enters invalid login and password information
    And user clicks on login button
    Then user is not able to see dashboard page

  @validLogin
  Scenario: valid admin login
    When user enters valid login and password information
    And user clicks on login button
    Then user is able to see dashboard page



