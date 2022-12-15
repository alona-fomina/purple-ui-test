@purpleMain
Feature: Testing main page

  Background:
    Given user goes to homepage

    @Regression
  Scenario: Validating main page
    And dismisses the popup
    Then user should see purple logo
    Then Validate navigation headers
      | Mattresses    |
      | Pillows       |
      | Sheets        |
      | Bedding       |
      | Bed Frames    |
      | Seat Cushions |
      | Gifts         |
      | Sale          |