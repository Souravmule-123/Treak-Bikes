Feature: Verify Payment Gateway Functionality

  Scenario: Successful payment using valid card detail
    Given I launch "DemoGuru" Application
    And I click on "Payment GateWay Project"
    Then I Add a Quantity of Mother Elephant With Babies Soft Toy
    And I click on Buy Now Option
    Then I verify the Payment Amount of Selected Quantity of Mother Elephant With Babies Soft Toy
    And I fill the "CardNumber","ExpirationMonth","ExpirationYear","CVVCode"
    And I click on Pay Tab
    Then I verify Successiful message as well as Order ID
    And I close the Browser

  Scenario: Display correct credit card limit for generated card
    Given I launch "DemoGuru" Application
    And I click on "Payment GateWay Project"
    Then I click on credit card Limit Btn
    And I fill the "CardNumber"
    Then I click on Submit Button
    And I verify Credit Card Balance Verification
    And I close the Browser

  Scenario: Generate valid credit card number for testing
    Given I launch "DemoGuru" Application
    And I click on "Payment GateWay Project"
    When I click on the "generate card"
    And i Verify this text "Here is your New Card"
    And I close the Browser