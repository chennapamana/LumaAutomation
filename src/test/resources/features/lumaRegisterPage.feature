@HRMLoginPage
Feature: OrangeHRM login functionalities

  Scenario: Verifying Login page with valid credentials
    Given User is in OrangeHRM login page
    Then Verify user is in correct page
    When User enters Username in Username input field
    When User enters Password in Password input field
    When User click on Login button
    Then Verify User is in Secure Dashboard page
