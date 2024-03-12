Feature: Testing Proposals Functionality

  #TPX-5 - Oleksandr
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


#TPX-6 - Alina
  Scenario: Customer Proposal Validation
    Given Customer navigates to Techtorial CRM url
    And Customer enters valid email and password
    Then Customer validates the page title "Apple LLC"
    When Customer clicks Proposals menu from top navigation bar
    Then Customer validates that proposal "Alex_Proposal_Test_TC5" is on the list and total is "$300.30"
    When Customer gets the proposal number from "Alex_Proposal_Test_TC5" and saves it to proposal_id
    And Customer clicks on the proposal from the table and validates proposal_id matches h4 header
    Then Customer validates proposal data
      | page_title              | item1        | item2          | button |
      | Alex_Proposal_Test_TC5 | Asus Monitor | Ethernet Cable | Accept |
    When Customer clicks Accept and Sign buttons
    Then Customer validates red signature error message "Please sign the document."
    When Customer draws a signature in canvas and clicks Sign
    Then Customer validates status label "Accepted" with green background

#TPX-7 - Diana
  Scenario: Verify proposal status as employee
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    Then  set Table length "All" from drop down menu
    Then  from table verify that approved proposal status label is "Accepted"


#TPX-10  -  Hacer
  Scenario: Add comment to proposal and convert it to invoice
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    And Search proposal name "Alex_Proposal_Test_TC5" from search box which is on tha top of table right corner
    Then Verify that listed proposal data
      | proposalSubject           | proposalProjectName   | proposalStatus |
      | Alex_Proposal_Test_TC5   | Apple Project         | Accepted       |
    When Click associated proposal id from Proposal # column, and From new panel, click Comments tab
    And Add comment as "Alex_Proposal_Test_TC5 is accepted for invoice", and Click Add Comment button.
    And Verify that proposal comment added and that next to Comments tab there is "1" badge for total comment.
    And Click Convert button, and Select Invoice button from drop down menu.
    And Verify that customer is "Apple LLC" as default from form
    And Scroll down page and click Save button.
    And Verify that there is red "Unpaid" label next to record header.
    Then Verify that record header that starts with "INV-" same number with Invoice Number section in the form




  Scenario: Delete last added proposal
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    Then Click first Proposal number, More button, Delete and press OK in the confirmation pop up









