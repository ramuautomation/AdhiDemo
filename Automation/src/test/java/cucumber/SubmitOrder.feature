@Order
Feature: Purchase the order from Ecommerce website
Background: 
Given I launch Ecommerce application

Scenario Outline: Positive test of Submitting Order
Given Logged in with user <name> and password <password>
When I add product <productName> to cart
And Checkout <productName> and Submit the Order
Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page
Examples:
          |name              |password|productName    |
          |test@practice.com |Test1234|ZARA COAT 3    |
          |test@success.com  |Test5678|ADIDAS ORIGINAL|