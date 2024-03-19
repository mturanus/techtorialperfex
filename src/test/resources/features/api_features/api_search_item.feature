#TPX-28-API-Search-and-item-information - Diana

Feature: Search and Item API Information

  Scenario: Customer API Response
    Given user has "https://techtorialperfex.com/perfexcrm/api" and "/items/search/ethernet"
    When User sends "GET" request
    Then User validates status code is 200
    * verify response "[0].rate" is "10.00"
    * verify response "[0].id" is "2"


