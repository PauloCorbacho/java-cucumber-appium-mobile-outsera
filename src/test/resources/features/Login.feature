Feature: Application Login
  As an application user
  I want to log in
  So I can access restricted areas

  Scenario: Login with valid credentials
    Given I am on the login screen
    When I enter a valid username
    And I enter a valid password
    And I tap the login button
    Then I should see the home screen

  Scenario: Login with invalid credentials
    Given I am on the login screen
    When I enter an invalid username
    And I enter an invalid password
    And I tap the login button
    Then I should see an error message