@Smoke
Feature: login

  Background:
    Given user goes to "https://features:watchoutforsharks@features.purple.com/"

  @CreatingAccount
  Scenario:
    And user click on My Account button
    Then user click Create One link
    And user puts user information in create account section
    And user waits 5 seconds

  @SignInAccount
  Scenario:
    And user click on My Account button
    And user logs in with "alona.f@purple.com", "Fominishna2" credentials
    And user waits 5 seconds
