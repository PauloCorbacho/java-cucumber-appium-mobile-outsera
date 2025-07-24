Feature: Application Login
  As an application user
  I want to log in
  So I can access restricted areas

  Scenario Outline: Login with credentials
    Given I am on the login screen
    When I enter username "<username>"
    And I enter password "<password>"
    And I tap the login button
    Then I should see "<expected_result>"

    Examples: Valid and Invalid Combinations
      | username      | password       | expected_result    |
      | valid_user    | validPass123   | home screen        |
      | invalid_user  | any_password   | error message      |
      | valid_user    | invalidPass    | error message      |
      | ${EMPTY}      | validPass123   | error message      |
      | valid_user    | ${EMPTY}       | error message      |
      | valid_user    | short          | error message      |
      | valid_user    | wrong_case     | error message      |
      | valid_user    | with spaces    | error message      |

  Scenario: Login with expired password
    Given I am on the login screen
    When I enter username "valid_user"
    And I enter password "expiredPass123"
    And I tap the login button
    Then I should see "password expired message"