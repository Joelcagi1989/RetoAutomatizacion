Feature: Create token post request
  @CasoExitoso
  Scenario Outline: Send information post create token with response success
    Given Load user credentials
      | username   | password   |
      | <username> | <password> |
    When Call Post create token
    Then Should see the code 200

    Examples:
      | username     | password    |
      ##@externaldata@./src/test/resources/data/CreateTokenTestData.xlsx@Sheet1@1
   |admin   |password123|
