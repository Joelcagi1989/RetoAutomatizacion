Feature: Create booking post request
  @CasoExitoso
  Scenario Outline: Send information post create booking with response success
    Given Load booking data
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    When Call Post create booking
    Then Should see the code 200
    And Validate post response contain data firstname

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin | checkout | additionalneeds |
      ##@externaldata@./src/test/resources/data/CreateBookingTestData.xlsx@Sheet1@1
      | Pedro  | Gutierrez | 100 | true | 2024-03-01 | 2024-04-01 | Comics |
      | Javier | Jaramillo | 356 | true | 2024-03-15 | 2024-04-15 | Terror |

