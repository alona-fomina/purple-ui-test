@E2E
Feature: Testing User Flow

  Background:
    Given user goes to "https://purple.com"
    And user waits 3 seconds
    And dismisses the popup
    And user waits 2 seconds

    Scenario:Purchase Mattress
      And user clicks on "Mattresses" from top navigation
      And user navigates to Purple Mattress
      And user waits 4 seconds
      And user adds Purple Mattress to the cart
      And user proceeds to checkout
      And user waits 4 seconds
      Then user sends user information into shipping information menu
      And user confirm that shipping is the same as billing address
      Then user waits 5 seconds
      And then user click on paymentInfo button
      And user waits 4 seconds
      Then user send credit card information
      And user complete order


