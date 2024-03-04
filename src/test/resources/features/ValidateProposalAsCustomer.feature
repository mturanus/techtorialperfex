Feature: Validate Created Proposal As A Customer Functionality

  Scenario: Create New Proposal for a customer
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    And Click "New Proposal" button from top
    And Fill the Subject line with "Alina_Proposal_Test_TC5"
    And From Related dropdown select "Customer" option
    And Go to Customer filter and type "Apple" then select "Apple LLC" option from results
    And Go to Project filter and type "Apple" then select "#1 - Apple Project - Apple LLC"
    And Click Add Item button and select Asus Monitor items from drop down list: "(253.00) Asus Monitor"
    And There is a blue check button next to auto filled item. Click blue check button to add item
    And Click Add Item button and select Ethernet Cable items from drop down list: "(10.00) Ethernet Cable"
    And Change Qty of Ethernet Cable and type "2"
    And Click blue check button to add item
    Then Verify that Total is "$300.30"
    And Click Save & Send button
    And Find created Proposal by clicking "Sales", "Proposals" and verify that its status is "Sent"


  Scenario: Customer Proposal Validation
    Given Customer navigates to Techtorial CRM url
    And Customer enters valid email and password
    Then Customer validates the page title "Apple LLC"
    When Customer clicks Proposals menu from top navigation bar
    Then Customer validates that proposal "Alina_Proposal_Test_TC5" is on the list and total is "$300.30"
    When Customer gets the proposal number from "Alina_Proposal_Test_TC5" and saves it to proposal_id
    And Customer clicks on the proposal from the table and validates proposal_id matches h4 header
    Then Customer validates proposal data
      | page_title              | item1        | item2          | button |
      | Alina_Proposal_Test_TC5 | Asus Monitor | Ethernet Cable | Accept |
    When Customer clicks Accept and Sign buttons
    Then Customer validates red signature error message "Please sign the document."
    When Customer draws a signature in canvas and clicks Sign
    Then Customer validates status label "Accepted" with green background

  Scenario: Delete last added proposal
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    Then Click first Proposal number, More button, Delete and press OK in the confirmation pop up









