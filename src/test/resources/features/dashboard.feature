Feature: Testing Dashboard Functionality

  Scenario: Validate submodules presence and order
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click Sales button from left side navigation menu
    Then User validates the submodules are displayed in this order: 'Proposals','Estimates','Invoices','Payments','CreditNotes','Items'

