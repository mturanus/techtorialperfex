Feature: Testing Proposal API

#    TPX-32 - Alina
  Scenario: Create Proposal API Response
    Given user has "https://techtorialperfex.com/perfexcrm/api" and "/proposals"
    And Request has "proposals" data
    When User sends "POST" request
    Then User validates status code is 200
    * verify response "message" is "Proposal Added Successfully"


