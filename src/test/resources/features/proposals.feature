Feature: Testing Proposals Functionality

  Scenario: Create New Proposal for a customer
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    And Click "New Proposal" button from top
    And Fill the Subject line with "Alex_Proposal_Test_TC5"
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