@E2E @Smoke
Feature: Testing User Flow

  Background:
#    Given user goes to "https://purple3qa2.prod.acquia-sites.com/"
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
#    Then user sends user information into shipping information menu
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
    And user proceeds to "paypal" express checkout where URL is "https://www.paypal.com/checkoutnow"
    And user proceeds to "amazon" express checkout where URL is "https://www.amazon.com/"

    Examples:
      | TopNavMenu    | page            | product                |
      | Mattresses    | Purple Mattress | Purple Mattress        |
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
    And then user click on Affirm radio button
    Examples:
      | TopNavMenu    | page            | product                |
      | Mattresses    | Purple Mattress | Purple Mattress        |
#      | Pillows       | Pillows         | Purple Harmony™ Pillow |
#      | Sheets        | Sheets          | Kid's Sheets           |
#      | Bedding       | Bedding         | Purple Duvet           |
#      | Bed Frames    | Bed Frames      | Ascent Adjustable Base |
#      | Seat Cushions | Seat Cushions   | Ultimate Seat Cushion  |
