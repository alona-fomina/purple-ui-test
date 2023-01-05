@Smoke
Feature: login

  Background:
    Given user goes to homepage
    And user waits 5 seconds
    And dismisses the popup

  @CreatingAccount
  Scenario:
    And user click on My Account button
    Then user click Create One link
    And user goes to "https://tempmailo.com/" and getting temporary email address
    And user puts random user information in create account section
    And user verified email address
    And user logs in with random user credentials
    Then user validates random user dashboard
      | My Orders        |
      | My Profile       |
      | Manage Addresses |
      | Sign Out         |
    Then user click on My Order and validating order history
    Then user click on My Profile and validating user credentials and changing them
    Then user click on Manage Addresses and checking, adding, changing and reviewing
    Then user click on Sign Out and validates redirected to sign in portal


  @SignInAccount
  Scenario:
    And user click on My Account button
    And user puts user information in sign in section
    Then user clicks on My Profile and validate user information
    And user waits 5 seconds

