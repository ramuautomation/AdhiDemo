
@Error
Feature: Error Validation Login Page
 
  Scenario Outline: Verify Error message at login page
    Given I launch Ecommerce application
   Given Logged in with user <name> and password <password>
    Then "Incorrect email or password." error message is displayed

   Examples:
          |name              |password|
          |test@pr           |Test1234|