Feature: Testing the Login Functionality of Techtorial Work Website

  Background: Verify title and visibility of log_in
    Given User verifies the title is 'Techtorial CRM - Login'
    When User verifies log_in is visible on the page

  Scenario:Happy Path Login Functionality(Positive)
#    When User provides correct employee email and password, and login
    When Enter correct employee email and password
    Then User validates the title 'Dashboard' from MainPage


  Scenario: Negative Login Functionality(Incorrect email and password)
#    Given User validates the title is 'Techtorial CRM - Login' from LoginPage
#    And User validates the log_in is visible on the  page
    When User provides wrong credentials as "afhieuhf@gmail.com"  and "djendwnee" to the loginPage
    Then User validates 'Invalid email or password' and 'rgba(71, 85, 105, 1)' from loginPage

