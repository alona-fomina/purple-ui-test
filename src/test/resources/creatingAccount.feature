@Smoke
Feature: login

  Background:
    Given user goes to homepage

  @CreatingAccount
  Scenario:
    And user click on My Account button
    Then user click Create One link
    And user goes to "https://tempmailo.com/" and getting temporary email address
    And user puts random user information in create account section
    And user verified email address
    And user logs in with random user credentials
    Then user click on My Order and validating order history
    Then user validates random user dashboard

  @SignInAccount
  Scenario:
    And user click on My Account button
    And user puts user information in sing in section
    Then user clicks on My Profile and validate user information
    And user waits 5 seconds

