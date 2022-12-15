Feature: test
  @Login
  Scenario:
    Given user goes to homepage
    And user logs in with "alona.f@purple.com", "Fominishna2" credentials
    And user waits 7 seconds
    And takes the "access_token" from local storage

  Scenario: test
    Given user goes to "https://purple.com"
    When user goes to "https://purple.com" on new tab
    When user goes to "https://purple.com" on new tab