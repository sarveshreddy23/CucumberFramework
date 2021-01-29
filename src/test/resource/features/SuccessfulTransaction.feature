Feature: To Demo Successful Transaction

  Scenario Outline: Successful Credit Card Transaction
  Given user opens Midtrans Pillow app
  When user click on BUY NOW button
  When user click on CHECKOUT button
  When user click on CONTINUE button on Order Summary page
  When user choose Credit/Debit Card on Select Payment page
  When user enters "<cardNumber>", "<expiry>", "<CVV>" in Card Details page
  When user click on PAYNOW button on Card Details page
  When user enters "<OTP>" in Payment verification page
  And user click OK button on Payment Verification page
  Then Thank you for your Payment Message is displayed on Home page

    Examples:
      |cardNumber       | expiry |CVV |OTP   |
      |4811111111111114 |1224    |123 |112233|
