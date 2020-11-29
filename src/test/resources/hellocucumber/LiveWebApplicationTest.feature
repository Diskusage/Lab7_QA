Feature: Live web app test
  Scenario: Testing given variant

    Given User enters Google
    When User enters english query
    Then User gets results
    When User enters chinese query
    Then User gets results
    When User enters upper case request
    Then User gets same results
    When User searches for calculator
    Then A calculator is displayed
    When User searches for Google converter services
    Then Converter services are at the top of search panel