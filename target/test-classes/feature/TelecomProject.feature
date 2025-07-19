Feature: Automate relevant scenarios for Telecom Projects

  Scenario: To Validate and Automate the Telecom Projects
    Given I launch "DemoGuru" Application
    And I  enter the "UserName" and "pwd"
    Then I click on TelecomProject Tab
    And I click on Add Customer Button
    And I click on Done Button
#    And I click on Pending Button
    Then I click on FirstName and LastName details under Billing Address Section
    And I fill the "Email","Address","Mobile Number"
    Then I click on Submit Button
    And I verify this "customer ID"
    And I click on Home Button
    And I close the Browser


  Scenario: To verify the Add Tariff Functionality
    Given I launch "DemoGuru" Application
    Then I click on TelecomProject Tab
    And I click on Add Tariff Button
    Then I fill the Add Tariff Plans "Data"
    Then I click on Submit Button
    And I verify the "Add Tariff Plans Congratulation" Message
    And I close the Browser


  Scenario Outline:  To verify the Add Tariff Plan to Customer Functionality
    Given I launch "DemoGuru" Application
    Then I click on TelecomProject Tab
    And I click on Add Tariff Plan to Customer Button
    Then I Enter the "<CustomerID>"
    Then I click on Submit Button
    And I verify the "Add Tariff Plans To Customer Verification Message"
    Examples:
      | CustomerID |
      | 890522     |

  Scenario Outline: To verify the Pay Billing Functionality
    Given I launch "DemoGuru" Application
    Then I click on TelecomProject Tab
    And I click on Pay Billing
    Then I Enter the "<CustomerID>"
    Then I click on Submit Button
    And I verify the "Customer ID" "Customer Name"
    Examples:
      | CustomerID |
      | 475185     |






    