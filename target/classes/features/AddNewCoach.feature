Feature: add new coach to a team
  Background: user should have logged in and at least one team has to be added before
    Given I land on entry page
    When I enter email, password and click on enter
    Then I land on dashboard page

  Scenario: Add new coach to existing team
    When I click on Manage Teams on dashboard
    Then I land on Teams Page
    When I click on eye icon on the team for opening team detail
    And I click on add a coach for club
    When I enter coach info
    And I click on add button
