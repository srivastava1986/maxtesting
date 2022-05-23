Feature: Login
  Scenario:Successful Login
    Given Open Browser and Launch URL "https://qa.max.com/login/"
    When User enters Username
    And Click on Login button
    Then Display the Dashboard