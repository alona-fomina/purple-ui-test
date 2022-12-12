Feature: login

  @Login
  Scenario:
    Given user goes to "https://features:watchoutforsharks@features.purple.com/account/login"
    And user logs in with "alona.f@purple.com", "Fominishna2" credentials
    And user waits 7 seconds
    And takes the "access_token" from local storage




