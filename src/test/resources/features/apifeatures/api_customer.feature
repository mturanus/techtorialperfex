Feature: Customer API Validation for successful response

  Scenario: Customer API Response
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/customers"
    When the user send the "GET" request
    Then verify status code 200
    * verify number of values 5
    * verify response "[1].company" is "Ikea LLC"
    * verify response "[1].userid" is "5"
    * verify api response is ordered by "company"


  Scenario: Customer API Response
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/items/search/"
    When the user send the "GET" request
    Then verify status code 200
    * verify number of values 3
    * verify response "[1].name" is "(10.00) Ethernet Cable"


  Scenario: Customer API Response Proposals
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals"
    And the request has "proposals" data
    When the user send the "POST" request
    Then verify status code 200


  Scenario: Customer API Response Proposals Negative
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/proposals"
    And the request has "proposalsNegative" data
    When the user send the "POST" request
    Then verify status code 404
    * verify response "error.rel_type" is "The Rel Type field must be one of: lead,customer."