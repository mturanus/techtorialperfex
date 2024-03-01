Feature: Testing the Login Functionality of Techtorial Work Website

  Background: Verify title and visibility of log_in
    Given User verifies the title is 'Techtorial CRM - Login'
    When User verifies log_in is visible on the page

  Scenario:Happy Path Login Functionality(Positive)

    When User provides correct employee email and password
    And User clicks login button
    Then User validates the title 'Dashboard' from MainPage
