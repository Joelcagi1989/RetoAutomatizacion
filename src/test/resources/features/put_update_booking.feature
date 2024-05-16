Feature: Information put update booking
  @CasoExitoso
  Scenario Outline: Send information put update booking with response success
    Given Load booking data
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    When Call Put update booking
      | id   | token   |
      | <id> | <token> |
    Then Should see the code 200
    And Validate put update booking response contain data expected

    Examples:
      | id | token           | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | 16 | cb1ccaafd3f495a | Jose      | Gutierrez | 100        | true        | 2023-05-12 | 2023-06-28 | Comics          |
      | 39 | 1a5f4bfb655c527 | Javier    | Mora      | 356        | true        | 2023-06-28 | 2023-07-20 | Terror          |