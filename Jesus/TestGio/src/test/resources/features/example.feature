Feature: Example feature
  Scenario: Open Google and  verify title 1
    Given I open the browser
    When I navigate to google
    Then the title should be "Google"

  Scenario: Open Google and  verify title 2
    Given I open the browser
    When I navigate to google
    Then the title should be "Google"