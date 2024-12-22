
@web # this will decide whether to open WebDriver or AppiumDriver for below scenarios
Feature: Amplify Customer Login Feature
  I want to use this template for my feature file

  @run @amplify
  Scenario: Amplify Customer Valid Login
    Given Customer Login Page is opened
    And Perform Customer Login
    Then Customer Dashboard is displayed
 
  #@amplify
  #Scenario: Amplify Customer Invalid Login
    #Given Customer Login Page is opened
    #And Perform Customer Login
    #Then Customer Dashboard is displayed