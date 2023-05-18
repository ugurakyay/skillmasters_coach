Feature: Create a new live training
Background: user should have logged in and at least one team has to be added before
  Given I land on entry page
  When I enter email, password and click on enter
  Then I land on dashboard page

  Scenario: Create new live training
    When I click on View Training Plans button
    Then I land on trainings page
    When I click on Add new training button
    And I enter training Info
    And I click on continue button