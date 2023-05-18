Feature: create a soccer team on skillmasters

  Background: user should have logged in
    Given I land on entry page
    When I enter email, password and click on enter
    Then I land on dashboard page

  Scenario: Creating a new soccer team
    When I click on Manage Teams on dashboard
    Then I land on Teams Page
    When I click on Add new Team
    And I type team name on textbox
    And I click on create button