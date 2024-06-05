# src/test/resources/features/homePage.feature
Feature: CandyMapper Home Page
  Background:
    Given I open the browser

  Scenario: Open CandyMapper Home Page
    #Given I open the browser
    When I navigate to CandyMapper
    Then I should see the CandyMapper homepage

  Scenario: Cerrar ventana emergente
    #Given I open the browser
    When Yo cierro el pop-up
    Then Ya no veo el pop-up