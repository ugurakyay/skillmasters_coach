Feature: Write a Message for the team
Background: user should have logged in and at least one team has to be added before
  Given I land on entry page
  When I enter email, password and click on enter
  Then I land on dashboard page

  Scenario: Update a player’s teams
    When I click on players on the left team management menu
    Then I land on players page
    When I click on change teams on the player
    And I select teams on the opened page
    And I click on Update button