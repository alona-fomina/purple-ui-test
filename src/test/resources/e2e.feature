Feature: Go to Pillow

  Background:
    Given user goes to "https://purple.com"

    Scenario: Buying mattress flow
      Then user click on the mattress page
      And user click on the "shop now" button
      And user chose "King size"
      And user chose "Mattress Only"
      And user click "Add to the Card" button
      Then user click "No Thanks,Continue to the Card"
      And user click "Proceed Checkout"
