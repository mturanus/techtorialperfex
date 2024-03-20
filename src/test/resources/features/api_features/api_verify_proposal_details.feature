Feature: Testing Proposal Details

  #  TPX-26 - Oleksandr
  Scenario: Verify a proposal details
    Given user has "https://techtorialperfex.com/perfexcrm/api" and "/proposals/37"
    When User sends "GET" request
    Then User validates status code is 200
    And That id is "37" and subject is "Cristian_Proposal_Test_TC7"
    And There are 2 added items, 1 quantity of "Asus Monitor" and 2 quantity of "Ethernet Cable"
    And client company name is "Apple LLC"