@E2E @Smoke
Feature: Testing User Flow

  Background:
    Given user goes to homepage
    And user waits 5 seconds
    And dismisses the popup
#    And user agrees with the privacy policy

  @StandardPurchase
  Scenario Outline:
    And user clicks on "<TopNavMenu>" from top navigation
    And user navigates to "<page>"
    And user adds "<product>" to the cart
    And user proceeds to checkout
    Then user sends user information randomly
    And user confirm that shipping is the same as billing address
    And then user click on paymentInfo button
    Then user send credit card information
    And user complete order
    Examples:
      | TopNavMenu    | page            | product                |
      | Mattresses    | Purple Mattress | Purple Mattress        |
      | Pillows       | Pillows         | Purple Harmony™ Pillow |
      | Sheets        | Sheets          | Kid's Sheets           |
      | Bedding       | Bedding         | Purple Duvet           |
      | Bed Frames    | Bed Frames      | Ascent Adjustable Base |
      | Seat Cushions | Seat Cushions   | Ultimate Seat Cushion  |


  @ExpressCheckout
  Scenario Outline:
    And user clicks on "<TopNavMenu>" from top navigation
    And user navigates to "<page>"
    And user adds "<product>" to the cart
    And user proceeds to "paypal" express checkout where URL is "paypal.com/checkoutnow"
    And user proceeds to "amazon" express checkout where URL is "amazon.com/"

    Examples:
      | TopNavMenu | page            | product         |
      | Mattresses | Purple Mattress | Purple Mattress |
#      | Pillows       | Pillows         | Purple Harmony™ Pillow |
#      | Sheets        | Sheets          | Kid's Sheets           |
#      | Bedding       | Bedding         | Purple Duvet           |
#      | Bed Frames    | Bed Frames      | Ascent Adjustable Base |
#      | Seat Cushions | Seat Cushions   | Ultimate Seat Cushion  |


  @AffirmFinanceCheckOut
  Scenario Outline:
    And user clicks on "<TopNavMenu>" from top navigation
    And user navigates to "<page>"
    And user adds "<product>" to the cart
    And user proceeds to checkout
    Then user sends user information into shipping information menu
    And user confirm that shipping is the same as billing address
    And then user click on paymentInfo button
    And user waits 2 seconds
    And then user click on Affirm radio button
    Examples:
      | TopNavMenu | page            | product         |
      | Mattresses | Purple Mattress | Purple Mattress |


  @CheckingRecyclingFeeText
  Scenario Outline:
    And user clicks on "<TopNavMenu>" from top navigation
    And user navigates to "<page>"
    And user adds "<product>" to the cart
    And user proceeds to checkout
    Then user sends user information into shipping information menu for state "<state>"
    And user confirm that shipping is the same as billing address
    And user waits 3 seconds
    And then user verifies the "<feeType>" and the "<amount>"
    Examples:
      | TopNavMenu | page            | product         | state | feeType       | amount |
      | Mattresses | Purple Mattress | Purple Mattress | CA    | Recycling fee | $10.50 |
      | Mattresses | Purple Mattress | Purple Mattress | CT    | Recycling fee | $11.75 |
      | Mattresses | Purple Mattress | Purple Mattress | RI    | Recycling fee | $16.00 |
      | Mattresses | Purple Mattress | Purple Mattress | CO    | Delivery fee  | $0.27  |