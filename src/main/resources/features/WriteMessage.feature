Feature: Write a Message for the team
Background: user should have logged in and at least one team has to be added before
  Given I land on entry page
  When I enter email, password and click on enter
  Then I land on dashboard page
  When I click on Manage Teams on dashboard
  Then I land on Teams Page

Scenario: Write a message for the team
When I click on message button on the team
Then I land on Messages page
When I type a message on text area
And I click on send button