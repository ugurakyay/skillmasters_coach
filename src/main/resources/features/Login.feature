Feature:Login
  @happy
  Scenario: login with valid credentials
    Given I land on entry page
    When I enter email, password and click on enter
    Then I land on dashboard page