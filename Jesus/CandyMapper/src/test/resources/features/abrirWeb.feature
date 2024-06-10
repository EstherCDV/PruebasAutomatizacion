Feature: Pruebas sobre web CandyMapper
Background:
  Given Tengo una pagina web

  Scenario: Iniciar pagina web
    When Abro pagina web
    Then La pagina web se ha abierto

  Scenario: Cerrar ventana emergente
    Given Me muestra un mensaje emergente
    When Cierro el mensaje emergente
    Then Muestra la pagina principal de la web
    #Then Cerrar navegador