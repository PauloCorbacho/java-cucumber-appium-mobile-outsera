Feature: Navigation and validation
  Scenario: Validate menu navigation and elements
    Given I open the ApiDemos app
    When I navigate to "Accessibility" menu
    And I select "Accessibility Node Querying"
    Then I should see text "Take out the Menu Page" on screen