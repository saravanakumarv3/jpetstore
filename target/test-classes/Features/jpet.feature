Feature: Login
 
  @single
  Scenario: Successful Login to the page
    Given I open chrome browser
    When I navigate to index.html page
    And I provide username as hi and password as hi
    And I click on login button
    Then hi should be name