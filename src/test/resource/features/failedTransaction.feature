Feature: To demo Failed Transaction

  Scenario Outline: Failed Credit Card Transaction
    Given user opens Midtrans Pillow app
    When user click on BUY NOW button
    When user click on CHECKOUT button
    When user click on CONTINUE button on Order Summary page
    When user choose Credit/Debit Card on Select Payment page
    When user enters "<cardNumber>", "<expiry>", "<CVV>" in Card Details page
    When user click on PAYNOW button on Card Details page
    When user enters "<OTP>" in Payment verification page
    And user click OK button on Payment Verification page
    Then verify Transaction failure message

    Examples:
      |cardNumber       | expiry |CVV |OTP   |
      |4111111111111113 |1221    |123 |112233|

