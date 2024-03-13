Feature: Customer API Validation for successful response

  Scenario: Customer API Response
    Given I have base url "https://techtorialperfex.com/perfexcrm/api" and endpoint "/customers"
    When the user send the "GET" request
    Then verify status code 200
    * verify number of values 5
    * verify response "[1].company" is "Ikea LLC"
    * verify response "[1].userid" is "5"
    * verify api response is ordered by "company"

