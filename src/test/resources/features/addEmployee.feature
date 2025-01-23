Feature: adding employee

  Background:
    When user enters valid login and password information
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on pim option
    And user clicks add employee option

  @fullName
  Scenario: adding the employee first and last name
    When user enters first name and last name

  @invalidEmployee
  Scenario: adding invalid employee first and last name
    When user enters incorrect first name and last name error pops up

  @employeeId
  Scenario: adding first name, last name and employee ID
    And user enters first name, last name, and employee ID
