Feature: Automate relevant scenarios for Bank and Payment Gateway Projects

  Scenario: Register, analyze, and automate relevant scenarios in Bank and Payment Gateway applications
    Given I launch "DemoGuru" Application
    And I click on "Payment GateWay Project"
    Then I Add a Quantity of Mother Elephant With Babies Soft Toy
    And I click on Buy Now Option
    Then I verify the Payment Amount of Selected Quantity of Mother Elephant With Babies Soft Toy
    And I fill the "CardNumber","ExpirationMonth","ExpirationYear","CVVCode"
    And I click on Pay Tab
    Then I verify Successiful message as well as Order ID

  Scenario: I will check the credit card limit
    Given I launch "DemoGuru" Application
    And I click on "Payment GateWay Project"
    Then I click on credit card Limit Btn
    And I fill the "CardNumber"
    Then I click on Submit Button
    And I verify Credit Card Balance Verification

  Scenario: I will verify the card is generated
    Given I launch "DemoGuru" Application
    And I click on "Payment GateWay Project"
    When I click on the "generate card"
    And i Verify this text "Here is your New Card"