Feature: Information list get booking
  @CasoExitoso
  Scenario Outline: Send information list get booking with response success
    Given Load booking data
      | id   |
      | <id> |
    When Call Get booking
    Then Should see the code 200
    And Validate booking get response contain data expected
      | firstname   |
      | <firstname> |

    Examples:
      | id | firstname |
      | 16 | John      |
      | 39 | Jane      |
