Feature: Verify approved proposal as employee


  Scenario: Verify proposal status
    Given navigate to Techtorial CRM url
    When Enter correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And Click "Proposals" module
    Then  set Table length "All" from drop down menu
    Then  from table verify that approved proposal status label is "Accepted"


  #navigate to url: Techtorial CRM - Login
  #
  #Enter correct employee email and password
  #
  #Click "Sales" Module from left side navigation menu
  #
  #Click "Proposals" module
  #
  #Set Table length "All" from drop down menu that is next to Export button on top of table.
  #
  #From table verify that approved proposal status label is "Accepted"