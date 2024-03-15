Feature: Testing Customer API

#  TPX-26 - Alina
  Scenario: Customer API Response
    Given User has baseurl and endpoint
    When User sends "GET" request
    Then User validates status code is 200
    And User validates number of values is 5
    And User validates user ids "2","3","4","5","9"
    And User validates companies are ordered alphabetically

