Feature: Create a new live private workout
Background: user should have logged in and at least one team has to be added before
  Given I land on entry page
  When I enter email, password and click on enter
  Then I land on dashboard page

  Scenario: Create new live workout
    Given I click on private workouts menu on the left workouts and lessons menu
    When I land on private workouts page
    Then I click on Add new private workout button
    When I enter private workout info
    And I click on continue button