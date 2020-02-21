Feature: Account
  Valid and invalid account actions

  Scenario: User logs in with a valid credentials
    Given a user with valid credentials
    When the user logs in
    Then the user should be logged in

  Scenario: User logs in with invalid credentials
    Given a user with invalid credentials
    When the user logs in
    Then the user should not be logged in

  Scenario: User logs in with master credentials
    Given a user
    And user has username 'master'
    And user has password 'root'
    When the user logs in
    Then the user should be logged in

  Scenario Outline: User logs in with multiple credentials
    Given a user
    And user has username <username>
    And user has password <password>
    When the user logs in
    Then the user should be logged in

    Examples:
      | username | password |
      |    'master' |   'root' |
      |    'bram' |   'test' |
      |    'aafke' |   'test' |
      |    'corvadis' |   'test' |