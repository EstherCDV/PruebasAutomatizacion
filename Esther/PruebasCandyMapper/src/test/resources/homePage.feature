# src/test/resources/features/homePage.feature
Feature: CandyMapper Home Page
  Background:
    Given I open the browser

  Scenario: Open CandyMapper Home Page
    #Given I open the browser
    When I navigate to CandyMapper
    Then I should see the CandyMapper homepage