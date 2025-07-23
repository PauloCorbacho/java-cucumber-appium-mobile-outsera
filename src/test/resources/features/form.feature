Feature: Form submission
  Scenario: Submit form with valid data
    Given I open the form screen
    When I fill in:
      | Field | Value      |
      | Name  | John Doe   |
      | Email | test@email |
    And I submit the form
    Then I should see confirmation message