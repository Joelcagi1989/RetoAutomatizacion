Feature: Information delete booking

  Scenario Outline: Send information delete booking with response success
    Given Load booking data
      | id   |
      | <id> |
    When Call Delete booking
      | id   | token   |
      | <id> | <token> |
    Then Should see the code 201

    Examples:
      | id | token           |
      | 17 | 04564222b975171 |
      | 38 | b5c1daf2b3f5d6d |