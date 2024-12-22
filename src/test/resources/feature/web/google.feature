@portal
Feature: Google search
	@google @run
  Scenario Outline: Google Search Skype
    Given chrome browser is opened
    And www.google.com site is loaded
    When user searches for <data>
    And hit Enter
    Then <site> must be displayed

    Examples: 
      | data  | site              |
      | skype | www.skype.com     |
      | fb    | www.facebook.com  |
      | fb1   | www.facebook1.com |
