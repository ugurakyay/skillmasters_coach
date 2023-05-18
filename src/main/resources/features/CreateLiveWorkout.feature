Feature: Create a new live workout
Background: user should have logged in and at least one team has to be added before
  Given I land on entry page
  When I enter email, password and click on enter
  Then I land on dashboard page

  Scenario: Create new live workout
    Given I click on manage workouts button
    Then I land on Workouts page
    And I click on Create new workout
    And I enter workout Info
    And I click on continue button