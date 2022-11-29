@E2E
Feature: Testing User Flow

  Background:
    Given user goes to "https://purple.com/"
    And user waits 3 seconds
    And dismisses the popup
    And user waits 2 seconds

  Scenario Outline:
    And user clicks on "<TopNavMenu>" from top navigation
    And user navigates to "<page>"
    And user waits 5 seconds
    And user adds "<product>" to the cart
    And user proceeds to checkout
    And user waits 5 seconds
    Then user sends user information into shipping information menu
    And user confirm that shipping is the same as billing address
    Then user waits 5 seconds
    And then user click on paymentInfo button
    And user waits 5 seconds
    Then user send credit card information
    And user waits 5 seconds
    And user complete order
    Examples:
      | TopNavMenu | page            | product                |
      | Mattresses | Purple Mattress | Purple Mattress        |
      | Pillows    | Pillows         | Purple Harmony™ Pillow |
      | Sheets     | Sheets          | Kid's Sheets           |
      | Bedding    | Bedding         | Purple Duvet           |
