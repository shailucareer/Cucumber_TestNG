
@web # this will decide whether to open WebDriver or AppiumDriver for below scenarios
Feature: Amplify Admin Login Feature
  I want to use this template for my feature file

	@amplify
  Scenario: Amplify Admin Login
    Given Admin Login Page is opened
    And Perform Admin Login
    Then Admin Dashboard is displayed