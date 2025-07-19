Feature: Automate relevant scenarios for Telecom Projects

  Scenario: Successfully register a new telecom customer
    Given I launch "DemoGuru" Application
    And I  enter the "UserName" and "pwd"
    Then I click on TelecomProject Tab
    And I click on Add Customer Button
    And I click on Done Button
    Then I click on FirstName and LastName details under Billing Address Section
    And I fill the "Email","Address","Mobile Number"
    Then I click on Submit Button
    And I verify this "customer ID"
    And I click on Home Button
    And I close the Browser

  Scenario: Successfully add a new tariff plan with valid details
    Given I launch "DemoGuru" Application
    Then I click on TelecomProject Tab
    And I click on Add Tariff Button
    Then I fill the Add Tariff Plans "Data"
    Then I click on Submit Button
    And I verify the "Add Tariff Plans Congratulation" Message
    And I close the Browser

  Scenario Outline: Successfully assign existing tariff plan to registered customer
    Given I launch "DemoGuru" Application
    Then I click on TelecomProject Tab
    And I click on Add Tariff Plan to Customer Button
    Then I Enter the "<CustomerID>"
    Then I click on Submit Button
    And I verify the "Add Tariff Plans To Customer Verification Message"
    And I close the Browser
    Examples:
      | CustomerID |
      | 890522     |

  Scenario Outline: Successfully pay bill using customer ID
    Given I launch "DemoGuru" Application
    Then I click on TelecomProject Tab
    And I click on Pay Billing
    Then I Enter the "<CustomerID>"
    Then I click on Submit Button
    And I verify the "Customer ID" "Customer Name"
    And I close the Browser
    Examples:
      | CustomerID |
      | 475185     |






    