
@app # this will decide whether to open WebDriver or AppiumDriver for below scenarios
Feature: Amplify Customer App Login Feature

  @amplify 
  Scenario: Amplify Customer App Valid Login 1
    Given Customer App Login Screen is opened
    And Perform Customer App Login
    Then Customer App Dashboard is displayed
    
  @amplify 
  Scenario: Amplify Customer App Valid Login 2
    Given Customer App Login Screen is opened
    And Perform Customer App Login
    Then Customer App Dashboard is displayed
